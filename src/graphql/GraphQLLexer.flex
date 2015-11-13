package graphql;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static graphql.GraphQLTypes.*;

%%

%{
  public _GraphQLLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GraphQLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

STRING=\"[^\"]*\"
NUMBER=(\+|\-)?[:digit:]*
ID=[:letter:][a-zA-Z_0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  ","                { return COMMA; }
  ":"                { return COLON; }
  "="                { return EQUALS; }
  "{"                { return BRACE1; }
  "}"                { return BRACE2; }
  "("                { return PAREN1; }
  ")"                { return PAREN2; }
  "["                { return BRACKET1; }
  "]"                { return BRACKET2; }
  "@"                { return AT; }
  "$"                { return DOLLAR; }
  "!"                { return BANG; }
  "type"             { return TYPE; }
  "interface"        { return INTERFACE; }
  "input"            { return INPUT; }
  "implements"       { return IMPLEMENTS; }
  "query"            { return QUERY; }
  "mutation"         { return MUTATION; }
  "fragment"         { return FRAGMENT; }
  "..."              { return SPREAD; }
  "on"               { return ON; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }

  {STRING}           { return STRING; }
  {NUMBER}           { return NUMBER; }
  {ID}               { return ID; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
