# GraphQL IntelliJ Plugin

[Link to Plugin in Jetbrain's Repo](https://plugins.jetbrains.com/plugin/8038)

- syntax highlighting
- brace matching

![GraphQL Syntax Highlighting](images/graphql-file.png)

At the moment no separate color settings are available. The styles above can be achieved by manipulating the default language highlighting.

It's also possible to inject GraphQL into strings (Alt+Enter inside of the string):

![Injected into relay](images/in-relay.png)

## TODO:
- [comments](../../issues/2)
- [auto-inject GraphQL for string preceeded by `Relay.QL`](../../issues/3)
- [resolve references](../../issues/4)