Sophie Keith
Core Interpreter Project
Due Date: 3/23/18
Submission Date: 3/25/18

Compile and Run:
-This is a java file, run like any other
-compile: javac Main.java
-run: java Main coreprogram inputdata
~where core program and input data are the args parameters

Files submitted:
-Assign
-Comparison
-CompOp
-Conidtion
-DecSeq
-Exp
-Fac
-Id
-IdList
-If
-In
-Loop
-Main
-Operator
-Out
-Prog
-Readme
-Statement
-StateSeq
-Tab
-Tokenize

-The Tokenizer class-
~located in src>cse3341>keith>Tokenizer
~this is different than the one I submitted previously. this class has current token, next token but that correspond to integer/identifier
~my previous class just returned an array of integers, but this would not work for this portion
~also, I used java's built in functionality for Tokenizer
~I heavily commented to make sure it could be followed, given it was rerworked

Note:
-for some reason, a list of int/id's are printed at the beginning, I searched everywhere and could not find the source (does not effect anything), I'm assuming it is lost in the parsing
-there exists extraneous ";" after some assingments- tried to also find the culprit but it also seemed lost in parsing.
-overall, this was an incredibely difficult project. I spent a majority of time rewriting my tokenizer, then a huge amount of time debugging.
~it was difficult to parse, given even class called on one-another. I think I would have been able to follow better if I had not done so much parsing.

-The Main class-
~this takes in the arguments are scans them
~takes the text from the files and coverts to string
~passes the tokenizer class the string from file
~creates new program (which in turn calls parse), then calls print,execute

-The Id class-
~to keep track of already assigned id's, I used a hash
~if new id, create a new id, else, find it in hash
~this class also serves to get values of ids, used for other non-terminals.

-The Tab Class-
~I used this to pretty print.
~whenever I printed (depending on what token it was), I kept track of where the tab was.
~included in this was print tab (prints the current tab), tabCountMore (which incremented tab), and tabCountLess(which decremented tab)

-All of the other non-terminal classes-
~follow the same pattern of consuming tokens and parsing/executing/printing to other non-terminals.
~note, I did not have a "int" class, the reason being, I used java's build in functionality.

