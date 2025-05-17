import unittest
import sys

# from Calculator import Calculator

class TestClass(unittest.TestCase):

    def runTests(self):

        sys.path.insert(0, '../calc')

        self.assertEqual(True,False)
        
