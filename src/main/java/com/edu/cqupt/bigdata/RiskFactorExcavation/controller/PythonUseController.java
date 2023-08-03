package com.edu.cqupt.bigdata.RiskFactorExcavation.controller;
import com.edu.cqupt.bigdata.RiskFactorExcavation.util.PythonRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/PythonUse")
@CrossOrigin
@RestController
class PythonUseController {

    private final PythonRun pythonRun;

    @Autowired


    PythonUseController(PythonRun pythonRun) {
        this.pythonRun = pythonRun;
    }

    //@PostMapping("/predict")
    //public String predictDisease(@RequestBody List<String> symptoms) {
    //    try {
    //        if (symptoms.size() != 5) {
     //           return "Please provide exactly 5 symptoms";
     //       }

            // 设置Python脚本的路径
     //       String scriptPath = "F:/Code/Disease-prediction-using-Machine-Learning-master/test2-1.py";

            // 调用PythonRun类执行Python脚本
     //       String result = pythonRun.run(scriptPath, symptoms);
     //       return result;
     //   } catch (Exception e) {
     //       e.printStackTrace();
     //       return "Error occurred while predicting disease";


    @PostMapping("/predict")
    public Map<String, Object> predictDisease(@RequestBody List<String> symptoms) {
        Map<String, Object> result = new HashMap<>();

        try {
            if (symptoms.size() != 5) {
                result.put("error", "Please provide exactly 5 symptoms");
                return result;
            }

            // 设置Python脚本的路径
            String scriptPath = "F:/Code/Disease-prediction-using-Machine-Learning-master/test2.py";

            // 调用PythonRun类执行Python脚本
            String prediction = pythonRun.run(scriptPath, symptoms);

            // 将预测结果转换为Java对象
            Map<String, Object> predictionMap = parsePredictionResult(prediction);

            // 将预测结果放入结果Map中
            result.put("prediction", predictionMap);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", "Error occurred while predicting disease");
            return result;
        }
    }
    private Map<String, Object> parsePredictionResult(String prediction) {
        // 创建一个空的结果Map
        Map<String, Object> result = new HashMap<>();

        try {
            // 解析预测结果字符串为JSON对象
            JSONObject jsonResult = new JSONObject(prediction);

            // 提取各个预测结果并添加到结果Map中
            if (jsonResult.has("decision_tree")) {
                String decisionTreeResult = jsonResult.getString("decision_tree");
                result.put("decision_tree", decisionTreeResult);
            }

            if (jsonResult.has("random_forest")) {
                String randomForestResult = jsonResult.getString("random_forest");
                result.put("random_forest", randomForestResult);
            }

            if (jsonResult.has("naive_bayes")) {
                String naiveBayesResult = jsonResult.getString("naive_bayes");
                result.put("naive_bayes", naiveBayesResult);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            // 解析出错时返回空的结果Map
        }

        return result;
    }

}
