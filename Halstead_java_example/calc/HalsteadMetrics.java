import java.util.*;
import java.util.regex.*;

public class HalsteadMetrics {

    public String receivedOperators;
    public String receivedOperands;

    public int[] calculateHalstead(String file) {
        // Step 1: Remove full-line comments
        String[] lines = file.split("\\R"); // \R = any linebreak
        StringBuilder codeNoComments = new StringBuilder();
        for (String line : lines) {
            if (!line.trim().startsWith("//")) {
                codeNoComments.append(line).append("\n");
            }
        }
        // Step 2: Remove string literals
        String code = codeNoComments.toString();
        String stringLiteralPattern = "(\"[^\"]*\"|'[^']*')";
        code = code.replaceAll(stringLiteralPattern, "");

        // Step 3: Define operators
        Set<String> operators = new HashSet<>(Arrays.asList(
                "+", "-", "*", "/", "%", "**", "//",
                "=", "+=", "-=", "*=", "/=", "%=", "//=", "**=", "&=", "|=", "^=",
                "==", "!=", "<", ">", "<=", ">=",
                "and", "or", "not",
                "&", "|", "^", "~", "<<", ">>",
                "in", "not in", "is", "is not",
                ":", ",", ".", "->", "(", ")", "[", "]", "{", "}"));

        // Split word-like and symbol-like operators
        Set<String> wordOps = new HashSet<>();
        Set<String> symbolOps = new HashSet<>();
        for (String op : operators) {
            if (op.matches("^[a-z ]+$"))
                wordOps.add(op);
            else
                symbolOps.add(op);
        }

        // Create regex pattern
        List<String> wordOpList = new ArrayList<>(wordOps);
        wordOpList.sort((a, b) -> b.length() - a.length());
        String wordOpPattern = "\\b(" + String.join("|", wordOpList).replace(" ", "\\s+") + ")\\b";

        List<String> symbolOpList = new ArrayList<>(symbolOps);
        symbolOpList.sort((a, b) -> b.length() - a.length());
        String symbolOpPattern = String.join("|", symbolOpList.stream().map(Pattern::quote).toList());

        String fullOpPattern = wordOpPattern + (symbolOpPattern.isEmpty() ? "" : "|" + symbolOpPattern);

        // Step 4: Match operators
        List<String> opMatches = new ArrayList<>();
        Matcher opMatcher = Pattern.compile(fullOpPattern).matcher(code);
        while (opMatcher.find()) {
            opMatches.add(opMatcher.group());
        }

        // Step 5: Remove operators
        String codeNoOps = code.replaceAll(fullOpPattern, " ");

        // Step 6: Match operands
        List<String> operandMatches = new ArrayList<>();
        Matcher operandMatcher = Pattern.compile("\\b[a-zA-Z_][a-zA-Z_0-9]*\\b|\\b\\d+\\b").matcher(codeNoOps);
        while (operandMatcher.find()) {
            operandMatches.add(operandMatcher.group());
        }

        // Step 7: Remove Python keywords (except logic operators)
        Set<String> keywordSet = new HashSet<>(Arrays.asList(
                "False", "None", "True", "and", "as", "assert", "async", "await", "break",
                "class", "continue", "def", "del", "elif", "else", "except", "finally",
                "for", "from", "global", "if", "import", "in", "is", "lambda", "nonlocal",
                "not", "or", "pass", "raise", "return", "try", "while", "with", "yield"));
        keywordSet.removeAll(Arrays.asList("and", "or", "not", "in", "is")); // keep logic ops as valid

        List<String> operands = new ArrayList<>();
        for (String operand : operandMatches) {
            if (!keywordSet.contains(operand)) {
                operands.add(operand);
            }
        }

        // Step 8: Count
        Set<String> distinctOps = new HashSet<>(opMatches);
        Set<String> distinctOperands = new HashSet<>(operands);

        int n1 = distinctOps.size();
        int N1 = opMatches.size();
        int n2 = distinctOperands.size();
        int N2 = operands.size();

        receivedOperators = distinctOps.toString(); 
        receivedOperands = distinctOperands.toString();

        return new int[] {
            n1,n2,N1,N2
        };
    }
}
