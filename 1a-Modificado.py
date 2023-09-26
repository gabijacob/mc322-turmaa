import numpy as np
def metodo_newton (F, J, X, eps) :
    F_value = F(x)
    F_norm = np.linalg. norm (F_value, ord=2)
    iteration_counter = 0
    while abs (F_norm) > eps and iteration_counter < 100:
        delta = np.linalg. solve (J(x), -F_value)
        x = x + delta
        F_value = F(x)
        F_norm = np.linalg. norm (F_value, ord=2)
        iteration_counter += 1
        if abs (F_norm) > eps:
            iteration_conter = -1
    return x, iteration_counter

from sympy import *
x1, x2, X3, X4, X5, x6, x7, x8, x9, x10 = symbols ('x1 X2 x3 x4 x5 x6 x7 X8 x9 x10')

def f(n):
    if n == 1:
        return (3*x1*x3) + 2*x2 - 5 + sin(x1 - x2)*sin(x1+x2)
    elif n == 10:
        return 4*x10 - 3 - x9+exp(x9-x10)
    return - eval (f"x{n-1}") *exp(eval (f"x{n-1}") -eval (f"x{n}") ) \
    + sin(eval(f"x{n}")-eval(f"x{n+1}"))*sin(eval(f"x{n}")+eval(f"{n+1}")) \
    -8