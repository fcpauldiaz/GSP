/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsp;

import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import parser.gspGrammarLexer;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.gspGrammarParser;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author SDX
 */
public class GSP {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        CharStream cs =  CharStreams.fromFileName("inputBlocks.txt");

        gspGrammarLexer lexer = new gspGrammarLexer(cs);
        //lexer.removeErrorListeners();

        CommonTokenStream tokens = new CommonTokenStream( lexer);
        gspGrammarParser  parser = new gspGrammarParser(tokens);
        gspGrammarParser.ProgramContext contexto = parser.program();
        
        ParseTree tree = contexto;


        int errorsCount = parser.getNumberOfSyntaxErrors();
        System.out.println(errorsCount);
    }
    
}
