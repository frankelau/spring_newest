# spring_newest


protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
    String fileName = (String) model.get("filename");//文件名称
    JSONArray keys = JSONArray.fromObject(model.get("keys"));//数据keys

    JSONArray titileKeys = JSONArray.fromObject(model.get("titileKeys"));//表头与keys顺序对应
    Object[] heads = titileKeys.toArray();
    JSONArray dataList = JSONArray.fromObject(model.get("dataList"));//数据集合JSONArray
    JSONObject object = null;
    List<Object[]> datas_ = Lists.newArrayList();
    List data_ = null;
    for (int i = 0; i < dataList.size(); i++) {
        object = JSONObject.fromObject(dataList.get(i));
        data_ = Lists.newArrayList();
        for (int j = 0; j < keys.size(); j++) {
            String key = (String) keys.get(j);
            String value = (String) object.get(key);
            data_.add(value);
        }
        datas_.add(data_.toArray());
    }
    response.setContentType("application/vnd.ms-excel;charset=utf-8");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("Content-Disposition", "attachment;filename=" + encodeFilename(request, fileName));
    HSSFWorkbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet();// 创建一个Excel的Sheet
    // 1. header
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < heads.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue((String) heads[i]);
    }
    // 2. data
    int cellCount = heads.length;
    for (int i = 0; i < datas_.size(); i++) {
        Row row = sheet.createRow(i + 1);
        Object[] data = datas_.get(i);
        for (int j = 0; j < cellCount; j++) {
            Cell cell = row.createCell(j);
            if (data[j] != null) {
                cell.setCellValue(data[j].toString());
            } else {
                cell.setCellValue("");
            }
        }
    }
    OutputStream fOut = response.getOutputStream();
    wb.write(fOut);
    fOut.flush();
    fOut.close();
}

private static String encodeFilename(HttpServletRequest request, String fileName) {
    String agent = request.getHeader("USER-AGENT");
    try {
        if (null != agent && -1 != agent.indexOf("MSIE")) {
            // IE
            fileName = URLEncoder.encode(fileName, "UTF8");
        } else if (null != agent && -1 != agent.indexOf("Mozilla")) {
            // Firefox//此分支为了解决IE下火狐下载文件名为乱码问题
            fileName = MimeUtility.encodeText(fileName, "UTF8", "B");
        }
    } catch (UnsupportedEncodingException e) {
        try {
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        e.printStackTrace();
    }
    return fileName;
}
<!-- 文件上传解析器 -->  
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">  
    <property name="defaultEncoding" value="utf-8"></property>  
    <property name="maxInMemorySize" value="10960"></property>  
</bean>

