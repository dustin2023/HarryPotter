```
@startuml
[*] --> Sleeping
Flying --> Dead : not flew
Dead --> [*]
Flying --> Resting : flew
Resting --> Playful
Playful --> Sleeping
Sleeping --> Flying
@enduml
```