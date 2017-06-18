/*run(X,Y):-
    depth(X,DEPTH),
    diff(Y,N),
    init(N,L),
    constructBoard(L,N,S),
    run('A ',N,DEPTH,S).
*/
run(X,Y,S):-
    depth(X,DEPTH),
    diff(Y,N),
    init(N,L),
    constructBoard(L,N,S).


run(_,N,DEPTH,S):-
    isTerminal(S,N,R),
    R == 1,
    printbox(S,1,N),
    writeln("finish").

opp('A ','B ').
opp('B ','A ').

isR(1).

r(P,N,DEPTH,S,R):-
    R == 0,
    opp(P,NP),
    run(NP,N,DEPTH,S).%run('B ',N,DEPTH,S).

r(P,N,DEPTH,S,R):-
    R == 1,
    run(P,N,DEPTH,S).%run('A ',N,DEPTH,S).

run('A ',N,DEPTH,S):-
   % p == 'A ',
    printbox(S,1,N),
    write('Enter N1 followed by .'),
    read(N1),
    write('Enter N2 followed by .'),
    read(N2),
    play(N1,N2,'A ',S,NEWS,N,R),
    r('A ',N,DEPTH,NEWS,R).

f1(H1,H2,R):-
    H1 == H2,
    R is 0.

f1(H1,H2,R):-
    H1 \= H2,
    R is 1.

f(S1,S2,R):-
    getHeuristic(S1,H1),
    getHeuristic(S2,H2),
    f1(H1,H2,R).

run('B ',N,DEPTH,S):-
   % p == 'B ',
    SRANGE is N * N * -1,
    ERANGE is N * N ,
    alphabetamax(S,DEPTH,N,SRANGE,ERANGE,_,NEWS,NEWS2),
    %writeln(NEWS),
    %writeln(NEWS2),
    f(S,NEWS,R),
    r('B ',N,DEPTH,NEWS,R).

constructBoard(L,2,[L,L]).

constructBoard(L,5,[L,L,L,L,L]).

run:-
    writeln('Select the difficulty:'),writeln('1.Beginner'),writeln('2.Expert'),read(D),
    writeln('Select the level:'),writeln('1.Easy'),writeln('2.Medium'),writeln('3.Hard'),read(L),
    run(L,D).

init(0,[]).
/*
init(N,[((1,1),(1,1),(1,1),(1,1),'B ')|NEWL]):-
    NEWN is N -1 ,
    init(NEWN,NEWL).
*/
init(N,[((-1,-1),(-1,-1),(-1,-1),(-1,-1),'  ')|NEWL]):-
    NEWN is N -1 ,
    init(NEWN,NEWL).

horizontal(SH,EH):-
    SH \= -1,
    EH \= -1,
    write("--").

horizontal(SH,EH):-
    SH == -1,
    EH == -1,
    write("  ").

vertical(SV,EV):-
    SV \= -1,
    EV \= -1,
    write("| ").

vertical(SV,EV):-
    SV == -1,
    EV == -1,
    write("  ").

printtop([],_):-!.

printtop([((_,_),(ST,ET),(_,_),(_,_),_)|T],C):-
    write(C),
    horizontal(ST,ET),
    NEWC is C + 1 ,
    printtop(T,NEWC).

printleft([]):-!.

printleft([((SL,EL),(_,_),(_,_),(_,_),X)|T]):-
    vertical(SL,EL),
    write(X),
    printleft(T).

printright([((_,_),(_,_),(SR,ER),(_,_),_)]):-!,
    vertical(SR,ER) ,
    writeln('').

printright([((_,_),(_,_),(_,_),(_,_),_)|T]):-
    printright(T).

printdown([],_):-!.

printdown([((_,_),(_,_),(_,_),(SD,ED),_)|T],C):-
    write(C),
    horizontal(SD,ED),
    NEWC is C + 1 ,
    printdown(T,NEWC).

printbox([],_,_).

printbox([H],C,N):-!,
    printtop(H,C),
    NEWC is C + N ,
    writeln(NEWC),
    printleft(H),
    printright(H),
    NEWWC is NEWC + 1 ,
    printdown(H,NEWWC),
    NC is NEWWC + N ,
    write(NC),
    writeln('').

printbox([H|T],C,N):-
    printtop(H,C),
    NEWC is C + N ,
    writeln(NEWC),
    printleft(H),
    printright(H),
    NC is NEWC + 1 ,
    printbox(T,NC,N).

depth(1,1).

depth(2,3).

depth(3,5).

diff(1,2).

diff(2,5).


len([],0).

len([H|T],L):-
    len(T,NL),
    L is NL+1.



v(L,[H|T],R):-
    len(H,L).





isPA('A ').
isPB('B ').
iscolored((_,_,_,_,X),X).

color2([H|T],J,J,P):-
	iscolored(H,P).

color2([H|T],J,C2,P):-
	NEWC2 is C2 + 1,
	color2(T,J,NEWC2,P).

color1([H|T],I,J,I,P):-
	color2(H,J,0,P).

color1([H|T],I,J,C1,P):-
	NEWC1 is C1 + 1,
	color1(T,I,J,NEWC1,P).

color(S,I,J,P):-
	color1(S,I,J,0,P).

isTerminal3(((1,1),(1,1),(1,1),(1,1),'A '),1):-!.
isTerminal3(((1,1),(1,1),(1,1),(1,1),'B '),1):-!.
isTerminal3(_,0).


isTerminal2([H|T],N,C,NEWC):-!,
   % writeln(H),
  % writeln("isTerminal2"),
    isTerminal3(H,R),
   % writeln(T),
    NC is C + R,
    isTerminal2(T,N,NC,NEWC).

isTerminal2(S,N,C,C).
	%writeln("isTerminal2"),
	%writeln(S).



isTerminal1([H|T],N,C,R):-!,
    isTerminal2(H,N,C,NEWC),
    isTerminal1(T,N,NEWC,R).


isTerminal1(S,N,C,1):-
   N2 is N*N,
   %writeln(C),
   C == N2.

isTerminal1(S,N,C,0):-
   N2 is N*N,
   C < N2.

isTerminal([H|T],N,R):-

   isTerminal1([H|T],N,0,R) .

%getHeuristic(S,_,2).



getHeuristic3((_,_,_,_,P),P,1):-!.
getHeuristic3((_,_,_,_,X),P,0):-
    P \= X.
getHeuristic3(_,_,0).



getHeuristic2([H|T],C1,NEWC1,C2,NEWC2):-!,
    getHeuristic3(H,'A ',R1),
    NC1 is C1 + R1,
    getHeuristic3(H,'B ',R2),
    NC2 is C2 + R2,
    getHeuristic2(T,NC1,NEWC1,NC2,NEWC2).

getHeuristic2(S,C1,C1,C2,C2).



getHeuristic1([H|T],C1,C2,R):-!,
    getHeuristic2(H,C1,NEWC1,C2,NEWC2),
    getHeuristic1(T,NEWC1,NEWC2,R).

getHeuristic1(S,C1,C2,R):-
  R is C2 - C1.

getHeuristic([H|T],R):-

   getHeuristic1([H|T],0,0,R) .


/* alphabeta algorithm   general part*/
alphabetamax(State,Depth,N,_,_,Ret,_,_):-
        isTerminal(State,N,R),
        (R == 1;Depth == 0),!,
        getHeuristic(State,Ret).%write(State), write(Ret),nl.
        %writeln("return alphabetamax: ").

alphabetamin(State,Depth,N,_,_,Ret,_,_):-
        isTerminal(State,N,R),
        (R == 1;Depth == 0),!,
        getHeuristic(State,Ret).%write(State), write(Ret),nl.
        %writeln("return alphabetamin: ").


alphabetamax(State,Depth,N,Alpha,Beta,Ret,Next,Next2):-
		Depth > 0,
		%writeln("alphabetamax: "),
        getChildren(State,N,'B ',Children,CH2),
        selectChildmax(State,Children,CH2,Depth,N,Alpha,Beta,Ret,_,_,Next,Next2).

alphabetamin(State,Depth,N,Alpha,Beta,Ret,Next,Next2):-
		Depth > 0,
		%writeln("alphabetamin: "),
        getChildren(State,N,'A ',Children,CH2),
        selectChildmin(State,Children,CH2,Depth,N,Alpha,Beta,Ret,_,_,Next,Next2).


min(A,B,A,VA,X,_,VA,_,X):-
        B>=A,!.

min(_,B,B,_,_,VB,VB,X,X).

max(A,B,A,VA,X,_,VA,_,X):-
        A>=B,!.

max(_,B,B,_,_,VB,VB,X,X).


selectChildmax(_,_,_,_,_,A,B,A,_,_,_,_):-
        B=<A,!.

selectChildmin(_,_,_,_,_,A,B,B,_,_,_,_):-
        B=<A,!.


/*traverse children list to get best*/

selectChildmax(_,[],_,_,_,Alpha,_,Alpha,BestTillNow,BestTillNow2,BestTillNow,BestTillNow2).
%writeln("return selectChildmax.").

selectChildmin(_,[],_,_,_,_,Beta,Beta,BestTillNow,BestTillNow2,BestTillNow,BestTillNow2).
%writeln("return selectChildmin.").

selectChildmax(State,[H|T],[H2|T2],Depth,N,Alpha,Beta,Ret,BestTillNow,BestTillNow2,SelectChild,SelectChild2):-
		%writeln("s3"),
		%writeln("selectChildmax."),
        NDepth is Depth -1,
        f(State,H,R),
        R == 0,
        %writeln(R),
        alphabetamin(H,NDepth,N,Alpha,Beta,NRet,_,_),
        max(Alpha,NRet,UpdetedAlpha,BestTillNow,BestTillNow2,H,NewBest,H2,NewBest2),
        selectChildmax(State,T,T2,Depth,N,UpdetedAlpha,Beta,Ret,NewBest,NewBest2,SelectChild,SelectChild2).

selectChildmin(State,[H|T],[H2|T2],Depth,N,Alpha,Beta,Ret,BestTillNow,BestTillNow2,SelectChild,SelectChild2):-
        %writeln("selectChildmin."),
        NDepth is Depth -1,
        f(State,H,R),
        R == 0,
        %writeln(R),
        alphabetamax(H,NDepth,N,Alpha,Beta,NRet,_,_),
        min(Beta,NRet,UpdetedBeta,BestTillNow,BestTillNow2,H,NewBest,H2,NewBest2),
        selectChildmin(State,T,T2,Depth,N,Alpha,UpdetedBeta,Ret,NewBest,NewBest2,SelectChild,SelectChild2).

selectChildmax(State,[H|T],[H2|T2],Depth,N,Alpha,Beta,Ret,BestTillNow,BestTillNow2,SelectChild,SelectChild2):-
		%writeln("s3"),
		%writeln("selectChildmax."),
        NDepth is Depth -1,
        f(State,H,R),
        R == 1,
        %writeln(R),
        alphabetamax(H,NDepth,N,Alpha,Beta,NRet,_,_),
        max(Alpha,NRet,UpdetedAlpha,BestTillNow,BestTillNow2,H,NewBest,H2,NewBest2),
        selectChildmax(State,T,T2,Depth,N,UpdetedAlpha,Beta,Ret,NewBest,NewBest2,SelectChild,SelectChild2).

selectChildmin(State,[H|T],[H2|T2],Depth,N,Alpha,Beta,Ret,BestTillNow,BestTillNow2,SelectChild,SelectChild2):-
        %writeln("selectChildmin."),
        NDepth is Depth -1,
        f(State,H,R),
        R == 1,
        %writeln(R),
        alphabetamin(H,NDepth,N,Alpha,Beta,NRet,_,_),
        min(Beta,NRet,UpdetedBeta,BestTillNow,BestTillNow2,H,NewBest,H2,NewBest2),
        selectChildmin(State,T,T2,Depth,N,Alpha,UpdetedBeta,Ret,NewBest,NewBest2,SelectChild,SelectChild2).


/*
getChildren(S,Ch):-
        bagof(X,move(S,X),Ch),!.

getChildren(_,[]).
*/

isEmpty([]).
notisEmpty(S):-
	isEmpty(S),!,
	fail.
notisEmpty(_).
getChildren(S,N,P,CH,CH2):-
    getChildren1(1,2,P,N,S,CH,CH2).

%getChildren(S,CH).

getChildren2(X,Y,P,N,S,[],[]):-
    NN is(N+1)*(N+1),
    X>NN.

getChildren2(X,Y,P,N,S,[NEWS|CH],[(X,Y)|CH2]):-
    play(X,Y,P,S,NEWS,N,R),
    %len(NEWS,L),
    %L>0,
    notisEmpty(NEWS),
    NEWX is X+1,
    NEWY is Y+1,
    %printbox(NEWS,1,N),
    getChildren2(NEWX,NEWY,P,N,S,CH,CH2).

getChildren2(X,Y,P,N,S,CH,CH2):-
    play(X,Y,P,S,NEWS,N,R),
    %len(NEWS,L),
    %L == 0,
    isEmpty(NEWS),
    NEWX is X+1,
    NEWY is Y+1,
    %printbox(NEWS,1,N),
    getChildren2(NEWX,NEWY,P,N,S,CH,CH2).


getChildren1(X,Y,P,N,S,CH,CH2):-

    NN is(N+1)*(N+1),
    X>NN,
    YY is N + 2,
   % writeln("C122"),
    getChildren2(1,YY,P,N,S,CH,CH2).

getChildren1(X,Y,P,N,S,[NEWS|CH],[(X,Y)|CH2]):-
    play(X,Y,P,S,NEWS,N,R),

    %len(NEWS,L),
    %L>0,
    %writeln(NEWS),
    notisEmpty(NEWS),
   % writeln("C11"),
    NEWX is X+1,
    NEWY is Y+1,
    YY is (NEWY - 1) mod (N + 1),
    YY \= 0,
    %printbox(NEWS,1,N),

    getChildren1(NEWX,NEWY,P,N,S,CH,CH2).

getChildren1(X,Y,P,N,S,[NEWS|CH],[(X,Y)|CH2]):-

    play(X,Y,P,S,NEWS,N,R),
    %len(NEWS,L),
    %L>0,
    notisEmpty(NEWS),
    NEWX is X+1,
    NEWY is Y+1,
    YY is (NEWY - 1) mod (N+1),
    YY == 0,
    NNEWX is X+2,
    NNEWY is Y+2,
    %printbox(NEWS,1,N),
%     writeln("C12"),
    getChildren1(NNEWX,NNEWY,P,N,S,CH,CH2).

getChildren1(X,Y,P,N,S,CH,CH2):-

    play(X,Y,P,S,NEWS,N,R),
    %len(NEWS,L),
    %L == 0,
    isEmpty(NEWS),
    NEWX is X+1,
    NEWY is Y+1,
    YY is (NEWY - 1) mod (N+1),
    YY \= 0,
%     writeln("C13"),
    getChildren1(NEWX,NEWY,P,N,S,CH,CH2).

getChildren1(X,Y,P,N,S,CH,CH2):-

    play(X,Y,P,S,NEWS,N,R),
    %len(NEWS,L),
    %L == 0,
    isEmpty(NEWS),
    NEWX is X+1,
    NEWY is Y+1,
    YY is (NEWY - 1) mod (N+1),
    YY == 0,
    NNEWX is X+2,
    NNEWY is Y+2,
%     writeln("C14"),
    getChildren1(NNEWX,NNEWY,P,N,S,CH,CH2).

setbox(((1,1),(1,1),(1,1),(1,1),'  ')).

markEdgeInBox2(COLUMN,_,COLUMN,3,P,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((ST,ET),(SL,EL),(SR,ER),(1,1),P)|T],1):-
    SB == -1,
    EB == -1,
    setbox(((ST,ET),(SL,EL),(SR,ER),(1,1),X)).

markEdgeInBox2(COLUMN,_,COLUMN,2,P,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((ST,ET),(SL,EL),(1,1),(SB,EB),P)|T],1):-
    SR == -1,
    ER == -1,
    setbox(((ST,ET),(SL,EL),(1,1),(SB,EB),X)).

markEdgeInBox2(COLUMN,_,COLUMN,1,P,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((ST,ET),(1,1),(SR,ER),(SB,EB),P)|T],1):-
    SL == -1,
    EL == -1,
    setbox(((ST,ET),(1,1),(SR,ER),(SB,EB),X)).

markEdgeInBox2(COLUMN,_,COLUMN,0,P,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((1,1),(SL,EL),(SR,ER),(SB,EB),P)|T],1):-
    ST == -1,
    ET == -1,
    setbox(((1,1),(SL,EL),(SR,ER),(SB,EB),X)).

markEdgeInBox2(COLUMN,_,COLUMN,3,_,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((ST,ET),(SL,EL),(SR,ER),(1,1),X)|T],0):-
    SB == -1,
    EB == -1.

markEdgeInBox2(COLUMN,_,COLUMN,2,_,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((ST,ET),(SL,EL),(1,1),(SB,EB),X)|T],0):-
    SR == -1,
    ER == -1.

markEdgeInBox2(COLUMN,_,COLUMN,1,_,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((ST,ET),(1,1),(SR,ER),(SB,EB),X)|T],0):-
    SL == -1,
    EL == -1.

markEdgeInBox2(COLUMN,_,COLUMN,0,_,[((ST,ET),(SL,EL),(SR,ER),(SB,EB),X)|T],[((1,1),(SL,EL),(SR,ER),(SB,EB),X)|T],0):-
    ST == -1,
    ET == -1.

markEdgeInBox2(COLUMN,_,COLUMN,3,_,[((ST,ET),(SL,EL),(SR,ER),(1,1),X)|T],[((ST,ET),(SL,EL),(SR,ER),(1,1),X)|T],0):-!,
   fail.
markEdgeInBox2(COLUMN,_,COLUMN,2,_,[((ST,ET),(SL,EL),(1,1),(SB,EB),X)|T],[((ST,ET),(SL,EL),(1,1),(SB,EB),X)|T],0):-!,
   fail.
markEdgeInBox2(COLUMN,_,COLUMN,1,_,[((ST,ET),(1,1),(SR,ER),(SB,EB),X)|T],[((ST,ET),(1,1),(SR,ER),(SB,EB),X)|T],0):-!,
   fail.
markEdgeInBox2(COLUMN,_,COLUMN,0,_,[((1,1),(SL,EL),(SR,ER),(SB,EB),X)|T],[((1,1),(SL,EL),(SR,ER),(SB,EB),X)|T],0):-!,
   fail.

markEdgeInBox2(J,ROW,COLUMN,POSITION,P,[],[],0):-
    fail.

markEdgeInBox2(J,ROW,COLUMN,POSITION,P,[H|T],[H|NEWL],R):-
    NEWJ is J + 1,
    markEdgeInBox2(NEWJ,ROW,COLUMN,POSITION,P,T,NEWL,R).

markEdgeInBox1(I,ROW,COLUMN,POSITION,P,[],[],0):-
   fail.

markEdgeInBox1(ROW,ROW,COLUMN,POSITION,P,[H|T],[NEWL|T],R):-
    markEdgeInBox2(0,ROW,COLUMN,POSITION,P,H,NEWL,R).


markEdgeInBox1(I,ROW,COLUMN,POSITION,P,[H|T],[H|NEWL],R):-
    NEWI is I + 1,
    markEdgeInBox1(NEWI,ROW,COLUMN,POSITION,P,T,NEWL,R).

markEdgeInBox(ROW,COLUMN,POSITION,P,L,NEWL,R):-
    markEdgeInBox1(0,ROW,COLUMN,POSITION,P,L,NEWL,R).


play(N1,N2,P,[H|T],NEWL,NN,R):-
    N is NN + 1,
    N1I is floor((N1 -1) / N) ,
    N1J is (N1 -1) mod N ,
    N2I is floor((N2 -1) / N) ,
    N2J is (N2 -1) mod N ,
    N1I == N2I ,
    BOXTR is N1I -1 , %buttom
    BOXBR is N1I , %top
    BOXCOLUMN is N1J ,
    BOXTR \= -1,
    BOXBR < NN,
    markEdgeInBox(BOXTR,BOXCOLUMN,3,P,[H|T],NEWLL,R1),
    markEdgeInBox(BOXBR,BOXCOLUMN,1,P,NEWLL,NEWL,R2),
    R is R1 \/ R2.
%     writeln("play1").

play(N1,N2,P,[H|T],NEWL,NN,R):-
     N is NN + 1,
    N1I is floor((N1 -1) / N) ,
    N1J is (N1 -1) mod N ,
    N2I is floor((N2 -1) / N) ,
    N2J is (N2 -1) mod N ,
    N1I == N2I ,
    BOXTR is N1I -1 , %buttom
    BOXBR is N1I , %top
    BOXCOLUMN is N1J ,
    BOXTR == -1,
    markEdgeInBox(BOXBR,BOXCOLUMN,1,P,[H|T],NEWL,R).
%     writeln("play2").

play(N1,N2,P,[H|T],NEWL,NN,R):-
    N is NN + 1,
    N1I is floor((N1 -1) / N) ,
    N1J is (N1 -1) mod N ,
    N2I is floor((N2 -1) / N) ,
    N2J is (N2 -1) mod N ,
    N1I == N2I ,
    BOXTR is N1I -1 , %buttom
    BOXBR is N1I , %top
    BOXCOLUMN is N1J ,
    BOXBR >= NN,
    markEdgeInBox(BOXTR,BOXCOLUMN,3,P,[H|T],NEWL,R).
%     writeln("play3").

play(N1,N2,P,[H|T],NEWL,NN,R):-
     N is NN + 1,
    N1I is floor((N1 -1) / N) ,
    N1J is (N1 -1) mod N ,
    N2I is floor((N2 -1) / N) ,
    N2J is (N2 -1) mod N ,
    N1J == N2J ,
    BOXRC is N1J -1 , %Left
    BOXLC is N1J , %Right
    BOXROW is N1I ,
    BOXRC \= -1,
    BOXLC < NN,
    markEdgeInBox(BOXROW,BOXRC,2,P,[H|T],NEWLL,R1),
    markEdgeInBox(BOXROW,BOXLC,0,P,NEWLL,NEWL,R2),
    R is R1 \/ R2.
%     writeln("play4").

play(N1,N2,P,[H|T],NEWL,NN,R):-
    N is NN + 1,
    N1I is floor((N1 -1) / N) ,
    N1J is (N1 -1) mod N ,
    N2I is floor((N2 -1) / N) ,
    N2J is (N2 -1) mod N ,
    N1J == N2J ,
    BOXRC is N1J -1 , %Left
    BOXLC is N1J , %Right
    BOXROW is N1I ,
    BOXRC == -1,
    markEdgeInBox(BOXROW,BOXLC,0,P,[H|T],NEWL,R).
%     writeln("play5").

play(N1,N2,P,[H|T],NEWL,NN,R):-
    N is NN + 1,
    N1I is floor((N1 -1) / N) ,
    N1J is (N1 -1) mod N ,
    N2I is floor((N2 -1) / N) ,
    N2J is (N2 -1) mod N ,
    N1J == N2J ,    BOXRC is N1J -1 , %Left
    BOXLC is N1J , %Right
    BOXROW is N1I ,
    BOXLC >= NN,
    markEdgeInBox(BOXROW,BOXRC,2,P,[H|T],NEWL,R).
%     writeln("play6").


play(N1,N2,P,[H|T],[],NN,0).
% writeln("play7").

is12((1,2)).
is23((2,3)).
is45((4,5)).
is56((5,6)).
is78((7,8)).
is89((8,9)).
is14((1,4)).
is25((2,5)).
is36((3,6)).
is47((4,7)).
is58((5,8)).
is69((6,9)).

