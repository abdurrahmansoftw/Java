public class DownloadFileTask implements Runnable {
    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (var i = 0; i < 10_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) break;
            status.incrementTotalBytes();
        }

        status.done();
        synchronized (status) {
            status.notifyAll();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
