package com.determent.limbo.noargs

class FactoryMachine() : FactoryMachineNoArg {

}

interface FactoryMachineNoArg {

    companion object {
        operator fun invoke(): FactoryMachine {
            return FactoryMachine()
        }
    }
}

fun main() {
    val a = FactoryMachineNoArg
    print(a)
}



