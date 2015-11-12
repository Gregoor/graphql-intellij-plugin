package graphql;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GraphQLSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey OPERATION_TYPE =
            createTextAttributesKey("OPERATION_TYPE",
                    DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey OPERATION_NAME =
            createTextAttributesKey("OPERATION_NAME",
                    DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey FIELD_NAME =
            createTextAttributesKey("FIELD_NAME",
                    DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey BAD_CHAR =
            createTextAttributesKey("BAD_CHARACTER",
                    HighlighterColors.BAD_CHARACTER);


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GraphQLLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        TextAttributesKey key = null;
        if (Arrays.asList(GraphQLTypes.QUERY, GraphQLTypes.MUTATION)
                .contains(tokenType)) {
            key = OPERATION_TYPE;
        } else if (tokenType.equals(GraphQLTypes.FIELD_NAME)) {
            key = FIELD_NAME;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            key = BAD_CHAR;
        }
        return pack(key);
    }

}
