import unittest
import sys
from Calculator import Calculator


class TestClass(unittest.TestCase):

    def runTests(self):
        sys.path.insert(0, './calc')
        self.calc = Calculator()
        self.test_add_general()
        self.test_add_negative()
        self.test_add_negative2()
        self.test_add_max()

        self.test_sub_general()
        self.test_sub_negative()
        self.test_sub_negative2()

        self.test_div_general()
        self.test_div_zero()

        self.test_sum_general()
        self.test_sum_max()

      
    def test_add_general(self):
     self.assertEqual(self.calc.add(20, 10), 30)

    def test_add_negative(self):
        self.assertEqual(self.calc.add(10, -1), -1)

    def test_add_negative2(self):
        self.assertEqual(self.calc.add(-65, 2), -1)

    def test_add_max(self):
        self.assertEqual(self.calc.add(1, 2**31 - 1), -1)  # Integer.MAX_VALUE in Java

    # ------------- sub -------------------
    def test_sub_general(self):
        self.assertEqual(self.calc.sub(30, 8), 22)

    def test_sub_negative(self):
        self.assertEqual(self.calc.sub(-30, 8), -1)

    def test_sub_negative2(self):
        self.assertEqual(self.calc.sub(14, -3), -1)

    # ------------- div -------------------
    def test_div_general(self):
        self.assertEqual(self.calc.divide(25, 5), 5)

    def test_div_zero(self):
        self.assertEqual(self.calc.divide(25, 0), -1)

    # ------------- sum -------------------
    def test_sum_general(self):
        self.assertEqual(self.calc.sum(18, 3), 54)

    def test_sum_max(self):
        self.assertEqual(self.calc.sum(2**31 - 1, 3), -1)
