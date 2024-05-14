int: n;  % Number of students
array[1..n, 1..3] of int: friends;  % Friends array where friends[i, j] is the j-th friend of student i


int: max_tables = ceil(n / 8.0);  % Maximum number of tables needed
array[1..n] of var 1..max_tables: table;  % Decision variable for table assignments

% Constraint: No table can have more than 8 students
constraint
    forall(t in 1..max_tables) (
        sum([table[i] == t | i in 1..n]) <= 8
    );

% Objective: Maximize the number of students sitting with their friends
var int: num_friends_seated_together = sum(i in 1..n, j in 1..3)(
    table[i] == table[friends[i, j]]
);

solve maximize num_friends_seated_together;

% Output the table assignments
output [
    "Table assignments: " ++ show(table) ++ "\n" ++
    "Number of friends seated together: " ++ show(num_friends_seated_together)
];
