package com.unclezs.novel.app.jfx.launcher;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * @author blog.unclezs.com
 * @since 2021/03/26 15:48
 */
public class UpdateView extends VBox {

  private final ProgressBar progressBar = new ProgressBar(0);
  private final Label whatNew = new Label();
  /**
   * 阶段显示
   */
  private final Label phase = new Label("正在检测更新...");

  public UpdateView() {
    // 进度
    progressBar.setProgress(-1);
    // 更新内容
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(whatNew);
    getChildren().addAll(whatNew, phase, progressBar);
  }

  public void setProgress(double progress) {
    this.progressBar.setProgress(progress);
  }


  /**
   * 设置本次更新的内容
   *
   * @param news 更新内容
   */
  public void setWhatNew(List<String> news) {
    StringBuilder updateMsg = new StringBuilder();
    int i = 1;
    for (String msg : news) {
      updateMsg.append(i++).append(msg).append("\n");
    }
    whatNew.setText(updateMsg.toString());
  }

  /**
   * 设置当前阶段
   *
   * @param phase 当前
   */
  public void setPhase(String phase) {
    this.phase.setText(phase);
  }
}
