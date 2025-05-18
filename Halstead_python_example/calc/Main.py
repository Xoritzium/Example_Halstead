from Halstead import Halstead
from TestClass import TestClass

import math

def main():


    # get file
    filePath = "./Calculator.py"
    with open(filePath, 'r') as file:
        content = file.read()

    # calculate n,N
    hal = Halstead()
    result = hal.halsteadMetrics(content)
    n1 = result['n1']
    n2 = result['n2']
    N1 = result['N2']
    N2 = result['N2']
    
    printer = "n1 = " + str(result['n1']) + '\nn2 = ' +str(result['n2']) + '\nN1 = ' + str(result['N1']) + '\nN2 = ' + str(result['N2']) + "\noperators = " + str(result['distinct_operators']) + "\noperands = " + str(result['distinct_operands']) + ' \n'          
    print("--------" + filePath+ "--------")
    print(printer) 

    # additional Halstead informations.
    programLength = N1+N2
    vocabularySize = n1+n2
    programVolume = programLength * math.log(vocabularySize,2)
    difficulty = (n1/2) * (N2/n2)
    level = 1/difficulty
    effort = programVolume*difficulty
    implementationTime = effort/18
    bugs = math.pow(effort,(2/3)) / 3000

    print(f"program Length = {programLength} \nvocabulary Size = {vocabularySize}\nprogram volume = {programVolume:.2f}\ndifficulty = {difficulty:.2f}\nlevel = {level:.2f}\neffort = {effort:.2f}\nimplementation Time = {implementationTime:.2f} sec\nbugs = {bugs:.2f}")    

    #run tests
    tests = TestClass() 
    #tests.runTests()

if __name__ == "__main__":
    main()




   