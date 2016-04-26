CREATE TABLE User(
  username VARCHAR(64) PRIMARY KEY, 
  firstname VARCHAR(64), 
  lastname VARCHAR(64), 
  email VARCHAR(64), 
  passhash VARCHAR(512), 
  lastlogin INTEGER
);

Create table UserTeam(
  name varchar(64) primary key,
  description varchar(64)
);

Create table UserTeamPlayers(
  UserTeamName varchar(64),
  ProPlayerName varchar(64),
  ProPlayerTeam varchar(64),
  position varchar(2),
  Foreign key (UserTeamName) references UserTeam(name),
  Foreign key (ProPlayerName) references ProPlayer(name)
  Foreign key (ProPlayerTeam) references ProPlayer(team)
  Primary key (UserTeamName, ProPlayerName, ProPlayerTeam)
);

Create table UserTournament(
  name varchar(64) primary key,
  lengthdays integer,
  integer startdate,
  enddate integer
);

Create table UserTournamentTeams(
  UserTournamentId integer primary key,
  UserTeamId integer,
  Foreign key (UserTournamentId) references UserTournament(id),
  Foreign key (UserTeamId) references UserTeam(id)
);

Create table ProTeam(
  name varchar(64) primary key,
  league varchar(40)
);

Create table ProPlayer(
  team varchar(64),
  name varchar(64),
  position varchar(2),
  number integer,
  Foreign key (team) references ProTeam(name),
  Primary key (team, name)
);

Create table ProPlayerStats(
  ProPlayerTeam varchar(64),
  ProPlayerName varchar(64),
  lastudpate integer,
  Stat1 integer,
  Stat2 integer,
  Stat3 integer,
  Stat4 integer,
  source varchar(25),
  Foreign key (ProPlayerTeam) references ProTeam(name),
  Foreign key (ProPlayerName) references ProPlayer(name),
  Primary key (ProPlayerTeam, ProPlayerName)
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
