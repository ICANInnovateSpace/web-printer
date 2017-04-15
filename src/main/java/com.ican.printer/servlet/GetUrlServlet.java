package com.ican.printer.servlet;

import com.ican.printer.document.SaveDocument;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrzhou on 17-4-14.
 *
 * 转存上传文档文件并计算文档页数
 * 根据文档页数计算出价格，统一下单
 * 生成支付url返回
 */
public class GetUrlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SaveDocument saveDocument = new SaveDocument();
        String path = saveDocument.getSaveDocument(req);
        req.setAttribute("path",path);
        req.getRequestDispatcher("jsp/scanQRcode.jsp").forward(req,resp);
    }
}
