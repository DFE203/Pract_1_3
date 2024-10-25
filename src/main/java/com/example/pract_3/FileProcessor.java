package com.example.pract_3;

import java.util.concurrent.BlockingQueue;

class FileProcessor implements Runnable {
    private BlockingQueue<File> queue;
    private String allowedFileType;

    public FileProcessor(BlockingQueue<File> queue, String allowedFileType) {
        this.queue = queue;
        this.allowedFileType = allowedFileType;
    }

    @Override
    public void run() {
        while (true) {
            try {
                File file = queue.take(); // Get file from the queue
                if (file.getFileType().equals(allowedFileType)) {
                    long processingTime = file.getFileSize() * 7; // Processing time
                    Thread.sleep(processingTime);
                    System.out.println(file.getFileType() +
                            " type processed with size " +
                            file.getFileSize() +
                            ". Processing time: " + processingTime + " ms.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

