<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Alunos</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Rg</th>
                        <th>Semestre</th>
                    </tr>
                    <xsl:for-each select="ALUNOS">
                        <xsl:for-each select="Aluno">
                            <tr>
                                <td>
                                    <xsl:value-of select="nome"/>
                                </td>
                                <td>
                                    <xsl:value-of select="idade"/>
                                </td>
                                <td>
                                    <xsl:value-of select="rg"/>
                                </td>
                                <td>
                                    <xsl:value-of select="cidade"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>