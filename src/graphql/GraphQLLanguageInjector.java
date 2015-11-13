package graphql;

import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

public class GraphQLLanguageInjector implements LanguageInjector {

    final static Language JavaScriptLanguage = Language.findLanguageByID("JavaScript");
    final static String TEMPLATE_STRING = "JSStringTemplateExpressionImpl";
    final static String prefix = "Relay.QL`";
    final static String suffix = "`";

    @Override
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host, @NotNull InjectedLanguagePlaces injectedLanguagePlaces) {
        if (host.getLanguage().isKindOf(JavaScriptLanguage) &&
                host.getClass().getSimpleName().equals(TEMPLATE_STRING)) {
            String hostText = host.getText();
            if (!hostText.contains("${") &&
                    hostText.startsWith(prefix) && hostText.endsWith(suffix)) {
                injectedLanguagePlaces.addPlace(
                        GraphQLLanguage.INSTANCE,
                        new TextRange(
                                prefix.length(),
                                hostText.length() - suffix.length()
                        ),
                        null, null);
            }
        }
    }

}
