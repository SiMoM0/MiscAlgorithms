#Implementation of a concrete model in Pyomo

#   min 2x_1 + 3x_2
#       3x_1 + 4x_2 >= 1
#       x_1, x_2 >= 0

#Execute from terminal with "pyomo solve ConcreteModel.py --solver=glpk"

import pyomo.environ as pyo
from pyomo.opt import SolverFactory

def buildmodel():
    #Model
    model = pyo.ConcreteModel()
    #Variables
    model.x1 = pyo.Var(domain=pyo.NonNegativeReals)
    model.x2 = pyo.Var(domain=pyo.NonNegativeReals)
    #Objective
    model.obj = pyo.Objective(expr = 2*model.x1 + 3*model.x2, sense=pyo.minimize)
    #Constraints
    model.Constraint1 = pyo.Constraint(expr = 3*model.x1 + 4*model.x2 >= 1)
    return model

if __name__ == '__main__':
    model = buildmodel()                    #build the model
    opt = SolverFactory('glpk')             #select the resolvent
    opt.solve(model)                        #solve the model
    print("x1 =", pyo.value(model.x1))
    print("x2 =", pyo.value(model.x2))