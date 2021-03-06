<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'studio.label', default: 'Studio')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-studio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-studio" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="studio" except="logo" />
            <div class="studio">
                <h2>${studio.name}</h2>
                <g:img uri="${studio?.logo}" />
                Cross-Platform: 
                <g:if test="${studio?.crossPlatform}">
                    Yes
                </g:if>
                <g:else>
                    No
                </g:else>

                <table>
                    <tr>
                        <th>Game</th>
                        <th>My Rating</th>
                    </tr>
                    <g:each in="${studio?.ips}" var="game">
                        <tr>
                            <td>
                                <a href="/IP/show/${game.id}">${game}</a>
                            </td>
                            <td>
                                ${game.myRating}
                        </tr>
                    </g:each>
                </table>

            </div>
            <g:form resource="${this.studio}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.studio}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
