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

[] Case6
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