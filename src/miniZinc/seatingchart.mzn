int: n;  % Number of students
array[1..n, 1..3] of int: friends;  % Friends array where friends[i, j] is the j-th friend of student i

int: max_tables = ceil(n / 8.0);  % Maximum number of tables needed
array[1..n] of var 1..max_tables: table;  % Decision variable for table assignments

% Weights for friends
array[1..3] of int: weights = [5, 3, 2];  % Higher weight for the first friend, medium for the second, lower for the third

% Constraint: No table can have more than 8 students
constraint
    forall(t in 1..max_tables) (
        sum([table[i] == t | i in 1..n]) <= 8
    );

% Objective: Maximize the weighted number of students sitting with their friends
var int: num_friends_seated_together = sum(i in 1..n, j in 1..3)(
    (table[i] == table[friends[i, j]]) * weights[j]
);

solve maximize num_friends_seated_together;

% Output the table assignments
output [
    "Table assignments: " ++ show(table) ++ "\n" ++
    "Score: " ++ show(num_friends_seated_together)
];

