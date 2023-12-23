```
@startuml
'left to right direction

class Phoenix {
	-sleep: int
    -awake: int
    -rest: int

    -currentState: State

    -name: String
    
    +void fly()
    +void tick()

    +boolean isAsleep()
    +boolean isPlayful()
    +boolean isFlying()
    +boolean isResting()
    +boolean isDead()

    +int getSleep()
    +int getRest()
    +int getAwake()
    +String getName()
}

abstract class State {
	#{static}logger: Logger
    #t: int
    #duration: int
    State tick(phoenix: Phoenix)
    abstract State successor(phoenix: Phoenix)
}

class RestingState extends State {
}

class FlyingState extends State {
    State fly(p: Phoenix)
}

class PlayfulState extends State {
}

class SleepingState extends State {
}

class DeathState extends State {
}

State --* Phoenix : current state

@enduml
