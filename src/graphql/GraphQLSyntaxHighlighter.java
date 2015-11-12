package graphql;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.tokenindex.Token;
import com.intellij.util.containers.ContainerUtil.ImmutableMapBuilder;
import com.thaiopensource.xml.dtd.om.Def;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GraphQLSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final Map<String, TextAttributesKey> KEYS = new HashMap<>();
    public static final Collection<IElementType> KEYWORDS = Arrays.asList(
            GraphQLTypes.TYPE, GraphQLTypes.INTERFACE, GraphQLTypes.INPUT,
            GraphQLTypes.IMPLEMENTS, GraphQLTypes.QUERY, GraphQLTypes.MUTATION,
            GraphQLTypes.FRAGMENT, GraphQLTypes.ON,
            GraphQLTypes.TRUE, GraphQLTypes.FALSE);
    public static final Collection<IElementType> BRACES = Arrays.asList(
            GraphQLTypes.BRACE1, GraphQLTypes.BRACE2);
    public static final Collection<IElementType> PARENS = Arrays.asList(
            GraphQLTypes.PAREN1, GraphQLTypes.PAREN2);

    static {
        Map<String, TextAttributesKey> highlightKeys = new ImmutableMapBuilder<String, TextAttributesKey>()
                .put("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
                .put("OPERATION_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
                .put("TYPE_REF", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
                .put("FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
                .put("ARGUMENT_NAME", DefaultLanguageHighlighterColors.PARAMETER)
                .put("VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
                .put("REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
                .put("DIRECTIVE", DefaultLanguageHighlighterColors.METADATA)
                .put("NUMBER", DefaultLanguageHighlighterColors.NUMBER)
                .put("STRING", DefaultLanguageHighlighterColors.STRING)
                .put("BRACES", DefaultLanguageHighlighterColors.BRACES)
                .put("PARENS", DefaultLanguageHighlighterColors.PARENTHESES)
                .put("BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
                .build();
        highlightKeys.forEach((s, key) ->
                KEYS.put(s, createTextAttributesKey(s, key)));
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GraphQLLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        String keyString = null;
        if (KEYWORDS.contains(tokenType)) {
            keyString = "KEYWORD";
        } else if (tokenType.equals(GraphQLTypes.NUMBER)) {
            keyString = "NUMBER";
        } else if (tokenType.equals(GraphQLTypes.STRING)) {
            keyString = "STRING";
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            keyString = "BAD_CHARACTER";
        } else if (BRACES.contains(tokenType)) {
            keyString = "BRACES";
        } else if (PARENS.contains(tokenType)) {
            keyString = "PARENS";
        }

        TextAttributesKey key = null;
        if (keyString != null) {
            key = KEYS.get(keyString);
            assert key != null : keyString;
        }

        return pack(key);
    }

}
