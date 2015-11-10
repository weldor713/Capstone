
create table if not exists `post` (
`post_id` int(11) not null AUTO_INCREMENT,
`title` varchar(50) not null,
`body` varchar(MAX) not null,
primary key (`post_id`)
) ENGINE=InnoDB default CHARSET=latin1 AUTO_INCREMENT=1
