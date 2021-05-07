package com.example.lab24.Scheduler;

import com.example.lab24.service.ItemService;
import com.example.lab24.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@Service
public class SchedulerService {

    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;

    @Scheduled(cron = "0 */30 * * * *")
    public void task() throws IOException {
        String path = "/Users/Fedor/IdeaProjects/PR_SEM4/src/LAB22/src/main/java/com/example/lab22/files";
        System.out.println("Scheduled task");
        for (File myFile : Objects.requireNonNull(new File(path).listFiles())) {
            if (myFile.isFile()) myFile.delete();
        }

        File file = new File(path +"/Items.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(itemService.getAllItems().toString());
        fileWriter.close();

        file = new File(path +"/Orders.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(itemService.getAllItems().toString());
        fileWriter.close();
    }
}
