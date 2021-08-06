# Story 1
[X] Case1
Given a parking lot, and a car
When park the car
Then return a parking ticket.

[X] Case2
Given a parking lot, and a valid parking ticket
When fetch the car
Then return a car.

[] Case3
Given a parking lot, and a invalid/no parking ticket
When fetch the car
Then return no car.

[] Case4
Given a parking lot, and an already used parking ticket
When fetch the car
Then return no car.

[] Case5
Given a parking lot at full capacity, and a car
When park the car
Then the car cannot be parked, and no ticket is provided

# Story 2
[] Case1
Given a parking lot, and an invalid/used parking ticket
When fetch the car
Then give message "Unrecognized parking ticket"

[] Case2
Given a parking lot at full capacity, and a car
When park the car
Then give message, "No Available Position"