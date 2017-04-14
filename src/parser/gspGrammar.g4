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
program: predicates initial_state goal_state actions;

predicates:
    'PREDICATES' (singular_predicate)+
;

singular_predicate:
    '-' name '(' multiple_params ')'
;

name: TOKEN+;
action_name: TOKEN+;
multiple_params: 
    params*;
params:  
    TOKEN ','?
;
action_params:   
    TOKEN ','?
;
multiple_action_params: 
    action_params*
;
actions:
    'ACTIONS' singular_action+
;

singular_action:
    '-' action_name '(' multiple_action_params ')' ':' precond effects
;
	
precond:
    'Precond:' conjunction
;

conjunction: ((negation? action_name '('action_params*')') ('^')?)+;

negation: '!';

effects:
    'Effects:' conjunction
;

initial_state:
    'INITIAL:' init_states 
;

init_states:
    (init_state ('^')?)*
;

init_state:
    name '(' multiple_params ')'
;

goal_state:
    'GOAL:' init_states 
;

init_goals:
    (init_goal ('^')?)*
;

init_goal:
    name '(' multiple_params ')'
;