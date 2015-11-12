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

STRING=\"[^\"]*\"|'[^']*'
NUMBER=(\+|\-)?[:digit:]*
NAMED_TYPE=[:letter:][a-zA-Z_0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return com.intellij.psi.TokenType.WHITE_SPACE; }

  ","                 { return COMMA; }
  ":"                 { return COLON; }
  "{"                 { return BRACE1; }
  "}"                 { return BRACE2; }
  "("                 { return PAREN1; }
  ")"                 { return PAREN2; }
  "query"             { return QUERY; }
  "mutation"          { return MUTATION; }
  "OPERATION_NAME"    { return OPERATION_NAME; }
  "FIELD_NAME"        { return FIELD_NAME; }
  "ARGUMENT_NAME"     { return ARGUMENT_NAME; }
  "ALIAS_NAME"        { return ALIAS_NAME; }
  "FRAGMENT_NAME"     { return FRAGMENT_NAME; }
  "VAR_NAME"          { return VAR_NAME; }
  "DIRECTIVE_NAME"    { return DIRECTIVE_NAME; }

  {STRING}            { return STRING; }
  {NUMBER}            { return NUMBER; }
  {NAMED_TYPE}        { return NAMED_TYPE; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
