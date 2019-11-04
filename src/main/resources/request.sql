CREATE TABLE managers
(
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    boss_id INTEGER REFERENCES managers ,
    name TEXT NOT NULL ,
    salary INTEGER NOT NULL CHECK ( salary > 0 ) ,
    plan INTEGER NOT NULL CHECK ( plan >= 0 ) ,
    unit TEXT
);