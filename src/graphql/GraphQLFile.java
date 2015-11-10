package graphql;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GraphQLFile extends PsiFileBase {

    public GraphQLFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, GraphQLLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GraphQLFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return GraphQLFileType.INSTANCE.getName();
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

}
