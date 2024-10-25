package com.example.pract_3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class FileGenerator implements Runnable {
    private BlockingQueue<File> queue;

    public FileGenerator(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] fileTypes = {"XML", "JSON", "XLS"};

        while (true) {
            try {
                Thread.sleep(random.nextInt(901) + 100); // Pause from 100 to 1000 ms
                String randomFileType = fileTypes[random.nextInt(fileTypes.length)];
                int randomFileSize = random.nextInt(91) + 10; // File size from 10 to 100
                File file = new File(randomFileType, randomFileSize);
                queue.put(file); // Add file to the queue
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
