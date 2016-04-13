CREATE TABLE main.User(
  id INTEGER PRIMARY KEY, 
  firstname VARCHAR(64), 
  lastname VARCHAR(64), 
  email VARCHAR(64), 
  passhash VARCHAR(512), 
  lastlogin INTEGER
);

Create table UserTeam(
  id integer primary key, 
  name varchar(64)
);

Create table UserTeamPlayers(
  UserTeamId integer,
  ProPlayerId integer,
  position varchar(2),
  Foreign key (UserTeamId) references UserTeam(id),
  Foreign key (ProPlayerId) references ProPlayer(id)
);

Create table UserTournament(
  id integer primary key,
  name varchar(64),
  lengthdays integer,
  integer startdate,
  enddate integer
);

Create table UserTournamentTeams(
  UserTournamentId integer,
  UserTeamId integer,
  Foreign key (UserTournamentId) references UserTournament(id),
  Foreign key (UserTeamId) references UserTeam(id)
);

Create table ProTeam(
  id integer primary key, 
  name varchar(64),
  league varchar(40)
);

Create table ProPlayer(
  id integer primary key,
  ProTeamId integer,
  name varchar(64),
  Number varchar(10),
  Foreign key (ProTeamId) references ProTeam(id)
);

Create table ProPlayerStats(
  ProPlayerId integer,
  lastudpate integer,
  Stat1 integer,
  Stat2 integer,
  Stat3 integer,
  Stat4 integer,
  source varchar(25),
  Foreign key (ProPlayerId) references ProPlayer(id)
);

Create table UserRole(
  UserId integer,
  UserTeamId integer,
  RoleId integer,
  Foreign key (UserId) references User(id),
  Foreign key (UserTeamId) references UserTeam(id),
  Foreign key (roleid) references Role(id)
);

Create table Role(
  id integer primary key,
  name varchar(32),
  Description varchar(128)
);


