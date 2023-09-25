Import numpy as np
def metodo_newton (F, J, X, eps) :
5
6
7
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
F_value = F(x)
F_norm = np. linalg. norm (F_value, ord=2)
iteration_counter = 0
while abs (F_norm) > eps and iteration_counter < 100:
delta = np. linalg. solve (J(x), -F_value)
x = x + delta
F_value = F(x)
F_norm = np. linalg. norm (F_value, ord=2)
iteration_counter += 1
if abs (F_norm) > eps:
iteration_conter = -1
return x, iteration_counter
from sympy import *
x1, x2, X3, X4, X5, x6, x7, x8, x9, x10 = symbols ('x1 X2 x3 x4 x5 x6 x7 X8 x9 x10')
def f(n):
if n == 1:
return (3*x1*×3) + 2*x2 - 5 + sin(x1 - ×2)*sin(x1+×2)
elif n == 10:
return 4*x10 - 3 - x9+exp(x9-×10)
return - eval (f"x{n-1}") *exp(eval (f"x (n-1)") -eval (f"x{n}") ) \
+ sin(eval(f"xiny")-eval(f"xin+1>"))*sin(eval(f"xinj")teval(f"in+1♪"))1
-8