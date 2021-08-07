# Story 1
[X] Case1
Given a parking lot, and a car  
When park the car  
Then return a parking ticket.

[X] Case2
Given a parking lot, and a valid parking ticket  
When fetch the car  
Then return a car.

[X] Case3
Given a parking lot, and a invalid/no parking ticket  
When fetch the car  
Then return no car.

[X] Case4
Given a parking lot, and an already used parking ticket  
When fetch the car  
Then return no car.

[X] Case5
Given a parking lot with two parked cars, and two parking tickets,  
When fetch the car Twice,  
Then return the right car with each ticket

[X] Case6
Given a parking lot at full capacity, and a car  
When park the car  
Then the car cannot be parked, and no ticket is provided

# Story 2
[X] Case1
Given a parking lot, and an invalid/used parking ticket  
When fetch the car  
Then give message "Unrecognized parking ticket"

[X] Case2
Given a parking lot at full capacity, and a car  
When park the car  
Then give message, "No Available Position"

# Story 3
[X] Case1
Given a parking lot, a standard parking boy, and a car  
When park the car,  
Then return a parking ticket.

[X] Case2
Given a parking lot with a parked car, a standard parking boy, and a parking ticket,  
When fetch the car,  
Then return the parked car.

[X] Case3
Given a parking lot with two parked cars, a standard parking boy, and two parking tickets,  
When fetch the car twice,  
Then return the right car with each ticket

[X] Case4
Given a parking lot, a standard parking boy, and a wrong parking ticket  
When fetch the car  
Then return nothing with error message "Unrecognized parking ticket."

[X] Case5
Given a parking lot, a standard parking boy, and a used parking ticket,   
When fetch the car,  
Then return nothing with error message "Unrecognized parking ticket."

[X] Case6
Given a parking lot without any position, a standard parking boy, and a car  
When park the car,  
Then return nothing with error message "No Available Position"

# Story 4
[X] Case1
Given a standard parking boy, who manage two parking lots, both with available position, and a car,   
When park the car,   
Then the car will be parked to the first parking lot

[X] Case2
Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car,   
When park the car,   
Then the car will be parked to the second parking lot

[X] Case3
Given a standard parking boy, who manage two parking lots, both with a parked car, and two parking ticket,   
When fetch the car twice,  
Then return the right car with each ticket 

[X] Case4
Given a standard parking boy, who manage two parking lots, and an unrecognized ticket,  
When fetch the car,  
Then return nothing with error message "Unrecognized parking ticket.”

[X] Case5 
Given a standard parking boy, who manage two parking lots, and a used ticket,  
When fetch the car,  
Then return nothing with error message "Unrecognized parking ticket."

[X] Case6 Given a standard parking boy, who manage two parking lots, both without any position, and a car,  
When park the car,  
Then return nothing with error message "No available position."

# Story 5
[X] Case1
Given a smart parking boy, a parking lot with 2 parked cars and 4 max capacity and a parking lot with 1 parked car and 4 max capacity  
When park the car,  
Then park the car in the second parking lot

[] Case2
Given a smart parking boy, a parking lot with 1 parked cars and 4 max capacity and a parking lot with 3 parked car and 4 max capacity  
When park the car,  
Then park the car in the first parking lot

# Story 6
[] Case1
Given a smart parking boy, a parking lot with 2 parked cars and 4 max capacity (50% free) and a parking lot with 2 parked car and 5 max capacity (60% free)  
When park the car,  
Then park the car in the second parking lot

[] Case2
Given a smart parking boy, a parking lot with 1 parked cars and 10 max capacity (90% free) and a parking lot with 3 parked car and 5 max capacity(40% free)  
When park the car,
Then park the car in the first parking lot

