--Seeds the tables
insert into BEER values(1, 'Cantillon', 'Fou Foune','5','Freaking delicious', 'Lambic - Fruit');
insert into BEER values(2, 'pFriem', 'Mosaic Pale','6.3','Many tropical hops', 'Pale Ale');
insert into BEER values(3, 'Weihenstephaner', 'Original','5.1','The Original', 'Helles');
insert into BEER values(4, 'Hamms', 'Hamms','5','The beer refreshing', 'Cold');
insert into BEER values(5, 'Cascade', 'Crude Diesel','8.8','Quite Aged', 'Imperial Stout');


insert into BEER_FESTIVAL values(1,'Fantastic Fest');
insert into BEER_FESTIVAL values(2,'Best festival');
insert into BEER_FESTIVAL values(3,'Not Best Fest');

insert into BEER_FESTIVAL_BEERS values(1,2);
insert into BEER_FESTIVAL_BEERS values(1,3);
insert into BEER_FESTIVAL_BEERS values(2,1);
insert into BEER_FESTIVAL_BEERS values(2,5);
insert into BEER_FESTIVAL_BEERS values(3,4);

