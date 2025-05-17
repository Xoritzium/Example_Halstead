import keyword
import re

class Halstead:

    def halsteadMetrics(self, code: str):
        # Step 1: Remove full-line comments
        code_lines = code.splitlines()
        code_no_comments = '\n'.join(line for line in code_lines if not line.strip().startswith('#'))

        # Step 2: Remove string literals
        string_literal_pattern = r"(\"[^\"]*\"|'[^']*')"
        code_no_strings = re.sub(string_literal_pattern, '', code_no_comments)

        # Step 3: Define operator set
        operators = {
            '+', '-', '*', '/', '%', '**', '//',
            '=', '+=', '-=', '*=', '/=', '%=', '//=', '**=', '&=', '|=', '^=',
            '==', '!=', '<', '>', '<=', '>=',
            'and', 'or', 'not',
            '&', '|', '^', '~', '<<', '>>',
            'in', 'not in', 'is', 'is not',
            ':', ',', '.', '->', '(', ')', '[', ']', '{', '}'
        }

        # Step 4: Match operators
        # Use word boundaries for word-like operators (like 'or', 'and') to prevent false matches inside identifiers
        word_operators = {op for op in operators if re.match(r'^[a-z]+$', op)}
        symbol_operators = operators - word_operators

        word_op_pattern = r'\b(?:' + '|'.join(re.escape(op) for op in sorted(word_operators, key=len, reverse=True)) + r')\b'
        symbol_op_pattern = r'|'.join(re.escape(op) for op in sorted(symbol_operators, key=len, reverse=True))
        full_op_pattern = word_op_pattern + (r'|' + symbol_op_pattern if symbol_op_pattern else '')

        op_matches = re.findall(full_op_pattern, code_no_strings)

        # Step 5: Remove operators for easier operand detection
        code_no_ops = re.sub(full_op_pattern, ' ', code_no_strings)

        # Step 6: Find operands (identifiers, numbers, string literals)
        operand_pattern = r'\b[a-zA-Z_][a-zA-Z_0-9]*\b|\b\d+\b'
        operand_matches = re.findall(operand_pattern, code_no_ops)

        # Step 7: Filter out Python keywords (except those also operators)
        keywords_to_ignore = set(keyword.kwlist) - {'and', 'or', 'not', 'in', 'is'}
        operands = [tok for tok in operand_matches if tok not in keywords_to_ignore]

        # Step 8: Count metrics
        n1 = len(set(op_matches))
        N1 = len(op_matches)
        n2 = len(set(operands))
        N2 = len(operands)

        return {
            'n1': n1, 'N1': N1,
            'n2': n2, 'N2': N2,
            'distinct_operators': set(op_matches),
            'distinct_operands': set(operands)
        }