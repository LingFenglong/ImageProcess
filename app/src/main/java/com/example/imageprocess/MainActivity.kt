package com.example.imageprocess

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.icu.text.ListFormatter.Width
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * 1. 图片的类型转换
 * 2. 如何在安卓studio中画图（绘图操作）
 *      - Canvas 画布
 *      - Paint 画笔
 *      - Path 绘制路径
 *      - Shader 填充图形的渲染类
 */

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getViews()
        setListener()

        intent
    }

    private fun setListener() {
        button.setOnClickListener {
//            drawCircle()
            drawTriangle()
        }
    }

    private fun drawTriangle() {
        val bitmap = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)

        val paint = Paint()
        paint.color = Color.argb(255, 200, 100, 80)    // 设置颜色
        paint.strokeWidth = 8F  // 设置线宽
        paint.style = Paint.Style.STROKE    // 设置填充

        val path1 = Path()
        path1.moveTo(400F, 100F)     // 移动到三角形顶点
        path1.lineTo(100F, 500F)     // 连接三角形左下角坐标
        path1.lineTo(700F, 600F)     // 连接三角形右下角坐标
        path1.lineTo(400F, 100F)     // 连接三角形顶点

        canvas.drawPath(path1, paint)
        path1.close()

        val path2 = Path()
        path2.addOval(100F, 100F,
            700F, 700F,
            Path.Direction.CCW
        )
        paint.color = Color.RED
        paint.strokeWidth = 8F
        paint.style = Paint.Style.FILL
        paint.textSize = 80F
        paint.textAlign = Paint.Align.CENTER
        canvas.drawTextOnPath("今天你原了吗？今天你原了吗？今天你原了吗？", path2, 10F, 10F, paint)
        path2.close()

        image.setImageBitmap(bitmap)
    }

    private fun drawCircle() {
        /**
         * 1. 创建Bitmap对象（画纸）
         * 2. 创建Canvas对象（花架）
         * 3. 创建Paint对象（画笔），设置属性
         * 4. 画圆形
         * 5. 图像控件中显示圆形
         */
        // Bitmap.Config.ARGB_8888 表示每个颜色用四个通道来表示，每个通道使用八位二进制
        val bitmap = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)

        val paint = Paint()
        paint.color = Color.GRAY    // 设置颜色
        paint.strokeWidth = 5F      // 设置线宽
        paint.style = Paint.Style.STROKE    // 设置填充

        canvas.drawCircle(400F, 400F, 100F, paint)

        image.setImageBitmap(bitmap)
    }


    private fun getViews() {
        button = findViewById(R.id.button)
        image = findViewById(R.id.image)
    }
}