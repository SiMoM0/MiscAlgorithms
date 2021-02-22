#Implementation of the Knapsack Problem with Pyomo, using a concrete model
#Resolvent: glpk

from pyomo.environ import *
from pyomo.opt import SolverFactory

n = 5
profits = [3, 2, 4, 3, 1]
weights = [2, 1, 3, 2, 1]
capacity = 4

def buildmodel():
    #Model
    model = ConcreteModel()
    #Set
    model.Items = RangeSet(0, n-1)
    #Params
    model.Profits = Param(model.Items, initialize=lambda model, j: profits[j])
    model.Weights = Param(model.Items, initialize=lambda model, j: weights[j])
    #Variables
    model.x = Var(model.Items, domain=NonNegativeIntegers, bounds=(0.0, 1.0))
    #Objective
    model.obj = Objective(expr = sum(model.Profits[j] * model.x[j] for j in model.Items), sense=maximize)
    #Constraints
    model.Constrs = Constraint(expr = sum(model.Weights[j] * model.x[j] for j in model.Items) <= capacity)
    return model

if __name__ == '__main__':
    model = buildmodel()
    opt = SolverFactory('glpk')
    opt.solve(model)
    for p in model.x:
        print("x[{}] = {}".format(p, value(model.x[p])))