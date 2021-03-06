package org.tasks.backup;

import static java.util.Collections.emptyList;

import com.todoroo.astrid.data.Task;
import java.util.List;
import org.tasks.backup.TasksJsonImporter.LegacyLocation;
import org.tasks.data.Alarm;
import org.tasks.data.CaldavAccount;
import org.tasks.data.CaldavCalendar;
import org.tasks.data.CaldavTask;
import org.tasks.data.Filter;
import org.tasks.data.Geofence;
import org.tasks.data.GoogleTask;
import org.tasks.data.GoogleTaskAccount;
import org.tasks.data.GoogleTaskList;
import org.tasks.data.Place;
import org.tasks.data.Tag;
import org.tasks.data.TagData;
import org.tasks.data.TaskAttachment;
import org.tasks.data.UserActivity;

class BackupContainer {

  private final List<TaskBackup> tasks;
  private final List<Place> places;
  private final List<TagData> tags;
  private final List<Filter> filters;
  private final List<GoogleTaskList> googleTaskLists;
  private final List<GoogleTaskAccount> googleTaskAccounts;
  private final List<CaldavAccount> caldavAccounts;
  private final List<CaldavCalendar> caldavCalendars;

  BackupContainer(
      List<TaskBackup> tasks,
      List<Place> places,
      List<TagData> tags,
      List<Filter> filters,
      List<GoogleTaskAccount> googleTaskAccounts,
      List<GoogleTaskList> googleTaskLists,
      List<CaldavAccount> caldavAccounts,
      List<CaldavCalendar> caldavCalendars) {
    this.tasks = tasks;
    this.places = places;
    this.tags = tags;
    this.filters = filters;
    this.googleTaskAccounts = googleTaskAccounts;
    this.googleTaskLists = googleTaskLists;
    this.caldavAccounts = caldavAccounts;
    this.caldavCalendars = caldavCalendars;
  }

  public List<TaskBackup> getTasks() {
    return tasks == null ? emptyList() : tasks;
  }

  public List<TagData> getTags() {
    return tags == null ? emptyList() : tags;
  }

  public List<Filter> getFilters() {
    return filters == null ? emptyList() : filters;
  }

  public List<GoogleTaskList> getGoogleTaskLists() {
    return googleTaskLists == null ? emptyList() : googleTaskLists;
  }

  public List<CaldavAccount> getCaldavAccounts() {
    return caldavAccounts == null ? emptyList() : caldavAccounts;
  }

  public List<CaldavCalendar> getCaldavCalendars() {
    return caldavCalendars == null ? emptyList() : caldavCalendars;
  }

  public List<GoogleTaskAccount> getGoogleTaskAccounts() {
    return googleTaskAccounts == null ? emptyList() : googleTaskAccounts;
  }

  public List<Place> getPlaces() {
    return places == null ? emptyList() : places;
  }

  static class TaskBackup {

    final Task task;
    final List<Alarm> alarms;
    final List<LegacyLocation> locations;
    final List<Tag> tags;
    final List<GoogleTask> google;
    final List<UserActivity> comments;
    private final List<Geofence> geofences;
    private final List<TaskAttachment> attachments;
    private final List<CaldavTask> caldavTasks;

    TaskBackup(
        Task task,
        List<Alarm> alarms,
        List<Geofence> geofences,
        List<Tag> tags,
        List<GoogleTask> google,
        List<UserActivity> comments,
        List<TaskAttachment> attachments,
        List<CaldavTask> caldavTasks) {
      this.task = task;
      this.alarms = alarms;
      this.geofences = geofences;
      this.tags = tags;
      this.google = google;
      this.comments = comments;
      this.attachments = attachments;
      this.caldavTasks = caldavTasks;
      locations = emptyList();
    }

    List<TaskAttachment> getAttachments() {
      return attachments == null ? emptyList() : attachments;
    }

    List<CaldavTask> getCaldavTasks() {
      return caldavTasks == null ? emptyList() : caldavTasks;
    }

    List<Geofence> getGeofences() {
      return geofences == null ? emptyList() : geofences;
    }
  }
}
