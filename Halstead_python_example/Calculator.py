<<<<<<< HEAD
class Calculator:
    # adds to positive integers and return the result
    #faulty inputs should return -1
    def add(self, a,b):
        if (a < 0 or b < 0): return -1
        return a+b 
            

    # substract the second from the first param if they are positiv and return the result
    #faulty inputs should return -1
    def sub(self, c,d):
        if (c < 0 or d < 0): return -1

        return c-d
    
    # devide one/two and return the result
    #faulty inputs should return -1
    def divide(self, one,two):
        if two == 0: return -1
        return one/two
    

    # sum the two positive integers and return the result.
    #faulty inputs should return -1
    def sum(self, first,second):
        if(first < 0 or second < 0): return -1
        return first*second
=======

class Calculator:
    # adds to positive integers and return the result
    def add(self, a,b):
        return 0
    
    # substract the second from the first param if they are positiv and return the result
    def sub(self, c,d):
        return 0
    
    # devide one/two and return the result
    def divide(self, one,two):
        return 0
    

    # sum the two positive integers and return the result.
    def sum(self, first,second):
        return 0
>>>>>>> master
