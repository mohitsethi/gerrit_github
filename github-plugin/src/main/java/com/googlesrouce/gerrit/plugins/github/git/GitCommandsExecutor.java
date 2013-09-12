// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.googlesrouce.gerrit.plugins.github.git;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GitCommandsExecutor {
  private static final int MAX_THREADS = 10;
  private ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

  @Inject
  public GitCommandsExecutor() {
  }

  public void exec(GitImportJob job) {
    executor.execute(job);
  }
}