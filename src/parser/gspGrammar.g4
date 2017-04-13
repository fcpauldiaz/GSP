/*
 * Universidad del Valle de Guatemala
 * 01/03/2017
 * Grammar to parse actions and predicates for goal stack planning
 */

grammar gspGrammar;

fragment LETTER : ('a'..'z'|'A'..'Z') ;

NEGATION: '!';
TOKEN:   LETTER  ;
EQUALS: '=';

WS : 
    [\t\r\n\f ]+ -> skip
    ;

COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'	
        | '/*' .*? '*/'	
        ) -> skip
    ;								
    
//PARSER
program: predicates actions;

predicates:
    'PREDICATES' (singular_predicate)+
;

singular_predicate:
    '-' name '(' params* ')'
;

name: TOKEN+;
action_name: TOKEN+;
params:  TOKEN ','?;
action_params:   TOKEN ','?;
actions:
    'ACTIONS' singular_action+
;

singular_action:
    '-' action_name '(' action_params* ')' ':' precond effects
;
	
precond:
    'Precond:' conjunction+
;

conjunction: (negation? action_name '('action_params*')') ('^')?;

negation: '!';

effects:
    'Effects:' conjunction+
;