package com.github.dahalibut.textflowers.handlers

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.markup.CustomHighlighterRenderer
import com.intellij.openapi.editor.markup.HighlighterTargetArea
import com.intellij.openapi.editor.markup.RangeHighlighter
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import java.awt.Color
import java.awt.Graphics


private object MyRenderer: CustomHighlighterRenderer {
    override fun paint(editor: Editor, highlighter: RangeHighlighter, g: Graphics) =
        drawFilled(g, editor, highlighter.startOffset, highlighter.endOffset)

    private fun drawFilled(g: Graphics, editor: Editor, startOffset: Int, endOffset: Int) {
        g.color = Color.BLACK
        g.fillRect(0, 0, 1, editor.lineHeight)
        g.color = Color.RED
        g.drawRect(0, 0, 1, editor.lineHeight)
    }
}


class MyTypedHandler : TypedHandlerDelegate() {
    override fun charTyped(c: Char, project: Project, editor: Editor, file: PsiFile): Result {
        editor.markupModel.addRangeHighlighter(null, 0, 0, 0, HighlighterTargetArea.EXACT_RANGE).apply { customRenderer = MyRenderer}
        println("yee")
        return super.charTyped(c, project, editor, file)
    }
}