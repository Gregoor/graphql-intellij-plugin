package graphql;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GraphQLAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        PsiElement parent = element.getParent();
        String keyString = null;

        if (parent instanceof GraphQLTypeRef) {
            keyString = "TYPE_REF";
        } else if (parent instanceof GraphQLOperationName) {
            keyString = "OPERATION_NAME";
        } else if (parent instanceof GraphQLFieldName) {
            keyString = "FIELD_NAME";
        } else if (parent instanceof GraphQLArgumentName) {
            keyString = "ARGUMENT_NAME";
        } else if (parent instanceof GraphQLVariable) {
            keyString = "VARIABLE";
        } else if (parent instanceof GraphQLFragmentName) {
            keyString = "REFERENCE";
        } else if (parent instanceof GraphQLDirective) {
            keyString = "DIRECTIVE";
        }

        if (keyString != null) {
            TextAttributesKey key = GraphQLSyntaxHighlighter.KEYS.get(keyString);
            assert key != null : keyString;
            holder.createInfoAnnotation(element, null).setTextAttributes(key);
        }
    }

}
