% Joseph Schauer
% CSc 448 Artificial Intelligence
% Project 3 - UFO Invasions or not?

%1. Ms. Langone made her sighting at some point earlier in the week than the one who saw %the balloon, but at some point later in the week, than the one who spotted the Frisbee
%( who isn't Mr. Hugh ).
%2. Friday's sighting was made by either Mr. Barnes or the one who saw a clothesline ( or %both ).
%3. Ms. Demetri did not make her sighting on Tuesday.
%4. Ms. Langone isn't the one whose object turned out to be a water tower.

% human reasoning:
% langone must have seen the clothesline on either wednesday or thursday
% barnes sighting was on friday, since friday was not the clothesline
% tuesday was hugh, since no one else could be
% demetri was also wednesday or thursday
% hugh did not see the frisbee (rule 1) or the clothesline (taken), or the balloon (rule 1), so he saw the water tower
% only demetri could have seen the frisbee, since that has to be before langone, so she saw the frisbee on wednesday
% langone saw the clothesline on thursday
% barnes saw the balloon on friday

day(tuesday). day(wednesday). day(thursday). day(friday).

person(langone). person(hugh). person(demetri). person(barnes).

object(balloon). object(frisbee). object(watertower). object(clothesline).

precedes(tuesday, wednesday). precedes(wednesday, thursday). precedes(thursday, friday).
precedes(tuesday, thursday). precedes(tuesday, friday). precedes(wednesday, friday).

solve :-
  object(LangoneObject), object(HughObject), object(DemetriObject), object(BarnesObject), 
  different(LangoneObject, HughObject, DemetriObject, BarnesObject),

  day(LangoneDay), day(HughDay), day(DemetriDay), day(BarnesDay),
  different(LangoneDay, HughDay, DemetriDay, BarnesDay),

  Sightings = [ [langone, LangoneDay, LangoneObject], [hugh, HughDay, HughObject], [demetri, DemetriDay, DemetriObject], [barnes, BarnesDay, BarnesObject] ],

  \==(LangoneObject, watertower), %rule 1
  day(BalloonDay), person(BalloonPerson), precedes(LangoneDay, BalloonDay), contains([BalloonPerson, BalloonDay, balloon], Sightings), % rule 1
  day(FrisbeeDay), person(FrisbeePerson), precedes(FrisbeeDay, LangoneDay), contains([FrisbeePerson, FrisbeeDay, frisbee], Sightings), %rule 1
  \==(frisbee, HughObject), %rule1

  (contains([ barnes, friday, BarnesObject], Sightings) ; contains( [Person, friday, clothesline], Sightings)), %rule 2

  \+(contains( [demetri, tuesday, DemetriObject], Sightings)), %rule 3

  \+(contains( [langone, LangoneDay, watertower], Sightings)), % rule 4

  write('\n'),
  write('langone saw the '), write(LangoneObject), write(' on '), write(LangoneDay), write('\n'),
  write('barnes saw the '), write(BarnesObject), write(' on '), write(BarnesDay), write('\n'),
  write('demetri saw the '), write(DemetriObject), write(' on '), write(DemetriDay), write('\n'),
  write('hugh saw the '), write(HughObject), write(' on '), write(HughDay), write('\n').
  
different(X, Y, Z, W) :- \==(X, Y), \==(X, Z), \==(X, W), \==(Y, Z), \==(Y, W), \==(Z, W).
contains(Entry, [H | T]) :- ==(Entry, H) ; contains(Entry, T).
contains(Entry, [_]) :- false.