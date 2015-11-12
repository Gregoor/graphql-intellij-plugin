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
        String key = null;

        if (parent instanceof GraphQLOperationName) {
            key = "OPERATION_NAME";
        } else if (parent instanceof GraphQLFieldName) {
            key = "FIELD_NAME";
        }

        if (key != null) {
            Annotation annotation = holder.createInfoAnnotation(element, null);
            annotation.setTextAttributes(GraphQLSyntaxHighlighter.KEYS.get(key));
        }
    }

}
