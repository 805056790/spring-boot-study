package pers.study.starter;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author panxin
 */
@Slf4j
@RestController
public class ResourceLoaderController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/load/1")
    public String load1() {
        String filePath = "package_number.txt";
        filePath = "/Users/panxin/Downloads/package_number.txt";
        try {
            List<String> dataList = Resources.readLines(Resources.getResource(filePath), Charsets.UTF_8);
            dataList.forEach(System.out::println);

            System.out.println("===");
            System.out.println(dataList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/load/2")
    public String load2() {
        String filePath = "file:/Users/panxin/Downloads/package_number.txt";;
        Resource banner = resourceLoader.getResource(filePath);
        InputStream in = null;
        try {
            in = banner.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
