package datasourcespkg.controllers;

import com.google.gson.Gson;
import datasourcespkg.persistence.*;
import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.Portal;
import datasourcespkg.domain.ParentSource;
import datasourcespkg.domain.PortalSource;
import datasourcespkg.domain.HistoryUpdates;
import datasourcespkg.domain.SourceTypes;
import datasourcespkg.domain.Dependencies;
import datasourcespkg.domain.EwControllers;
import datasourcespkg.domain.UpdateIntervals;
import datasourcespkg.domain.UpdateMethods;

import java.util.List;

import static spark.Spark.*;

public class RestController {

    public RestController() {

        before("*", (request, response)-> {

            response.header("Access-Control-Allow-Headers", "Content-Type, Content-Range, Content-Disposition, Content-Description");
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,PATCH,OPTIONS");
            response.header("Content-Type", "application/json; charset=utf-8");
        });


//--------------- P A R E N T   S O U R C E S ----------------------------

        // SELECT all
        get("/parentsource", (request, response) -> {
            ParentSourcesDao parentSourcesDao = new ParentSourcesDaoImpl();
            List<ParentSource> parentSource = parentSourcesDao.getAllParentSources();
            return new Gson().toJson(parentSource);
        });

        // SELECT 1
        get("/parentsource/:id", (request, response) -> {
            Long id = Long.valueOf(request.params(":id"));
            ParentSourcesDao parentSourcesDao = new ParentSourcesDaoImpl();
            ParentSource parentSources = parentSourcesDao.getParentSourceById(id);
            return new Gson().toJson(parentSources);
        });

        // SELECT - get all data sources for 1 parent
        get("/parentsource/:id/data", (request, response) -> {
            Long parentId = Long.valueOf(request.params(":id"));
            ParentSourcesDao parentSourcesDao = new ParentSourcesDaoImpl();
            List<DataSource> dataSources = parentSourcesDao.getDataSourcesForParent(parentId);
            return new Gson().toJson(dataSources);
        });

        // INSERT
        post("/parentsource", (request, response) -> {
            ParentSource parentSource = new Gson().fromJson(request.body().toString(), ParentSource.class);
            ParentSourcesDao parentSourcesDao = new ParentSourcesDaoImpl();
            ParentSource createdParentSource = parentSourcesDao.addParentSource(parentSource);
            return new Gson().toJson(createdParentSource);
        });

        // DELETE
        delete("/parentsource/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id").toString());
            ParentSourcesDao parentSourcesDao = new ParentSourcesDaoImpl();
            parentSourcesDao.deleteParentSource(id);
            response.status(200);
            return null;
        });

        // UPDATE  (ajax -- "PUT")
        post("/parentsource/put/:id", (request, response) -> {
            Long id = Long.valueOf(request.params(":id"));
            System.out.println("method : /parentsource/put/:id    " + id);
            ParentSource parentSource = new Gson().fromJson(request.body().toString(), ParentSource.class);
            parentSource.setParentSourceId(id);
            ParentSourcesDao parentSourcesDao = new ParentSourcesDaoImpl();
            ParentSource updatedParentSource = parentSourcesDao.updateParentSource(parentSource);
            return new Gson().toJson(updatedParentSource);

        });

        //--------------- D A T A   S O U R C E S ----------------------------

        // SELECT all
/*        get("/datasource", (request, response) -> {
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            List<DataSource> dataSources = dataSourcesDao.getAllDataSources();
            return new Gson().toJson(dataSources);
        });*/

        get("/datasource", (request, response) -> {
            // JAVASCRIPT : sendRequest('/datasource', 'GET').........
            // Long id = Long.valueOf(request.queryParams(String sortby));
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            List<DataSource> dataSources = dataSourcesDao.getAllDataSources();
            return new Gson().toJson(dataSources);
        });

 // ?name="John"

        get("/datasource/deactivated", (request, response) -> {
            Boolean deactivated = Boolean.valueOf(request.params("?deactivated=1"));
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            List<DataSource> dataSources = dataSourcesDao.getAllDeactivatedDataSources();
            return new Gson().toJson(dataSources);
        });

        // SELECT 1
        get("/datasource/:id", (request, response) -> {
            Long id = Long.valueOf(request.params(":id"));
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            DataSource dataSource = dataSourcesDao.getDataSourceById(id);
            return new Gson().toJson(dataSource);
        });

        // SELECT all Data Sources for 1 specific Portal
        get("/portalsources/:id/data", (request, response) -> {
            Long portalId = Long.valueOf(request.params(":id"));
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            List<DataSource> dataSource = dataSourcesDao.getDataSourcesForPortal(portalId);
            System.out.println("IN getDataSourcesForPortal");
            return new Gson().toJson(dataSource);
        });
        System.out.println("OUT getDataSourcesForPortal");

       // SELECT all portals for 1 data source
        get("/datasource/:id/portals", (request, response) -> {
            Long dataSourceId = Long.valueOf(request.params(":id"));
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            List<Portal> portals = dataSourcesDao.getPortalsForDataSource(dataSourceId);
            return new Gson().toJson(portals);
        });

        // INSERT  (ajax : insert)
        post("/datasource", (request, response) -> {
            DataSource dataSource = new Gson().fromJson(request.body().toString(), DataSource.class);
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            DataSource createdDataSource = dataSourcesDao.addDataSource(dataSource);
            return new Gson().toJson(createdDataSource);
        });

        // DELETE (ajax -- "DELETE")
        post("/datasource/delete/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id").toString());
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            dataSourcesDao.deleteDataSource(id);
            response.status(200);  // ??
            return null;
        });

        // UPDATE (ajax -- "PUT")
        post("/datasource/put/:id", (request, response) -> {
            Long id = Long.valueOf(request.params(":id"));
            System.out.println("request.body() = " + request.body());
            DataSource dataSource = new Gson().fromJson(request.body().toString(), DataSource.class);
            dataSource.setDataSourceId(id);
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            DataSource updatedDataSource = dataSourcesDao.updateDataSource(dataSource);
            return new Gson().toJson(updatedDataSource);
        });

        // UPDATE (ajax -- "PUT")  --   re-activate deactivated Data Source (one id)
        post("/datasource/activate/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id").toString());
            System.out.println("request.body() = " + request.body());
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            dataSourcesDao.activateDataSource(id);
            response.status(200);  // ??
            return null;
        });

/*
        // UPDATE (ajax -- "PUT")  ---    Example of List...   if it had been a list....     something like this    Need better code for handling "list" of items
        post("/datasource/activate", (request, response) -> {
            // Long id = Long.valueOf(request.params(":id"));
            System.out.println("request.body() = " + request.body());
            List<long> dataSourceIds = new Gson().fromJson(request.body().toString(), DataSource.class);
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            foreach (id in dataSourceIds) {
                boolean ok = dataSourcesDao.activateDataSource(id);
            }

            return true;
        });
*/



        //--------------- P O R T A L S ----------------------------

        // SELECT all
        get("/portal", (request, response) -> {
            PortalsDao portalsDao = new PortalsDaoImpl();
            List<Portal> portals = portalsDao.getAllPortals();
            return new Gson().toJson(portals);
        });

        // SELECT 1
        get("/portal/:id", (request, response) -> {
            Long id = Long.valueOf(request.params(":id"));
            PortalsDao portalsDao = new PortalsDaoImpl();
            Portal portal = portalsDao.getPortalById(id);
            return new Gson().toJson(portal);
        });

        // SELECT all data sources for 1 portal
        get("/portal/:id/data", (request, response) -> {
            Long portalId = Long.valueOf(request.params(":id"));
            // String id = request.params(":dataSource");
            PortalsDao portalsDao = new PortalsDaoImpl();
            List<DataSource> dataSources = portalsDao.getDataSourcesForPortal(portalId);
            return new Gson().toJson(dataSources);
        });

        // INSERT
        post("/portal", (request, response) -> {
            Portal portal = new Gson().fromJson(request.body().toString(), Portal.class);
            PortalsDao portalsDao = new PortalsDaoImpl();
            Portal createdPortal = portalsDao.addPortal(portal);
            return new Gson().toJson(createdPortal);
        });

        // DELETE (ajax -- "DELETE")
        post("/portal/delete/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id").toString());
            System.out.println(" JAVA PORTAL DELETE = " + id);
            PortalsDao portalsDao = new PortalsDaoImpl();
            portalsDao.deletePortal(id);
            response.status(200); // have on all REST commands ?
            return null;
        });

        // UPDATE (ajax -- "PUT")
        post("/portal/put/:id", (request, response) -> {
            Long id = Long.valueOf(request.params(":id"));
            Portal portal = new Gson().fromJson(request.body().toString(), Portal.class);
            portal.setPortalId(id);
            PortalsDao portalsDao = new PortalsDaoImpl();
            Portal updatedPortal = portalsDao.updatePortal(portal);
            return new Gson().toJson(updatedPortal);
        });

        //------------- P O R T A L  S O U R C E S   xref table ----------------------------

        // SELECT all PortalSources for 1 portal
        get("/portalsource/portal/:id", (request, response) -> {
            Long portalId = Long.valueOf(request.params("id").toString());
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            List<PortalSource> portalSource = portalSourcesDao.getPortalSourcesByPortal(portalId);
            return new Gson().toJson(portalSource);
        });

        // SELECT all PortalSources for 1 data source
        get("/portalsource/data/:id", (request, response) -> {
            Long dataSourceId = Long.valueOf(request.params("id").toString());
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            List<PortalSource> portalSource = portalSourcesDao.getPortalSourcesByDataSource(dataSourceId);
            return new Gson().toJson(portalSource);
        });

        // SELECT - get all portals which are linked to 1 specific parent source
        get("/portalsource/:id/parent", (request, response) -> {
            Long parentId = Long.valueOf(request.params(":id"));
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            List<PortalSource> portalSource = portalSourcesDao.getPortalsForParent(parentId);
            return new Gson().toJson(portalSource);
        });

        // INSERT  (ajax : insert)    (for when linking a data source to a portal)
        post("/portalsource", (request, response) -> {
            PortalSource portalSourceId = new Gson().fromJson(request.body().toString(), PortalSource.class);
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            PortalSource createdPortalSource = portalSourcesDao.addPortalSource(portalSourceId);
            return new Gson().toJson(createdPortalSource);
        });

        // DELETE   (ajax : delete)    (for when deleting a Portal)
        post("/portalsource/delete/portal/:portalid", (request, response) -> {
            Long portalId = Long.valueOf(request.params("portalid").toString());
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            portalSourcesDao.deletePortalSourceByPortal(portalId);
            response.status(200);
            return null;
        });

        // DELETE   (ajax : delete)    (for when deleting a Data Source)
        post("/portalsource/delete/data/:id", (request, response) -> {
            Long dataSourceId = Long.valueOf(request.params("id").toString());
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            portalSourcesDao.deletePortalSourceByDataSource(dataSourceId);
            response.status(200);
            return null;
        });

        // DELETE   (ajax : delete)    (for when unlinking 1 Data Source from 1 Portal)
        post("/portalsourcelink/delete/data/:id/:pid", (request, response) -> {
            Long dataSourceId = Long.valueOf(request.params("id").toString());
            Long portalId     = Long.valueOf(request.params("pid").toString());
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            portalSourcesDao.deletePortalSourceByDataSourceByPortal(dataSourceId, portalId);
            response.status(200);
            return true;
        });

        // n o t  n e e d e d ??
        // UPDATE  by - amended Portal
        put("/portalsource/:id", (request, response) -> {
            Long portalSourceId = Long.valueOf(request.params(":id"));
            PortalSource portalSource = new Gson().fromJson(request.body().toString(), PortalSource.class);
            portalSource.setPortalSourceId(portalSourceId);
            PortalSourcesDao portalSourcesDao = new PortalSourcesDaoImpl();
            PortalSource updatedPortalSource = portalSourcesDao.updatePortalSource(portalSource, portalSourceId);
            return new Gson().toJson(updatedPortalSource);
        });


        //------------- H I S T O R Y   U P D A T E S  ----------------------------

        // SELECT all HISTORY UPDATES for 1 specific Data Source id
        get("/historyupdates/list/:id", (request, response) -> {
            Long datasourceId = Long.valueOf(request.params("id").toString());
            HistoryUpdatesDao historyUpdatesDao = new HistoryUpdatesDaoImpl();
            List<HistoryUpdates> historyUpdates = historyUpdatesDao.getHistoryUpdatesForDataSource(datasourceId);
            return new Gson().toJson(historyUpdates);
        });

        // SELECT current (latest) HISTORY UPDATES for 1 specific Data Source id
        get("/historyupdates/lastactiveupdate/:id", (request, response) -> {
            Long datasourceId = Long.valueOf(request.params("id").toString());
            HistoryUpdatesDao historyUpdatesDao = new HistoryUpdatesDaoImpl();
            HistoryUpdates historyUpdates = historyUpdatesDao.getHistoryUpdatesCurrent(datasourceId);
            return new Gson().toJson(historyUpdates);
        });

        // SELECT all "current" update items from HISTORY UPDATES (i.e. latest item for each Data Source)
        get("/historyupdates/alllastactive", (request, response) -> {
            HistoryUpdatesDao historyUpdatesDao = new HistoryUpdatesDaoImpl();
            List<HistoryUpdates> historyUpdates = historyUpdatesDao.getAllCurrentHistoryUpdates();
            return new Gson().toJson(historyUpdates);
        });

        // INSERT  (ajax : insert)
        post("/historyupdates", (request, response) -> {
            HistoryUpdates historyUpdates = new Gson().fromJson(request.body().toString(), HistoryUpdates.class);
            HistoryUpdatesDao historyUpdatesDao = new HistoryUpdatesDaoImpl();
            HistoryUpdates createdHistoryUpdates = historyUpdatesDao.addHistoryUpdates(historyUpdates);
            return new Gson().toJson(createdHistoryUpdates);
        });

/*
        // INSERT  (ajax : insert)
        post("/datasource", (request, response) -> {
            DataSource dataSource = new Gson().fromJson(request.body().toString(), DataSource.class);
            DataSourcesDao dataSourcesDao = new DataSourcesDaoImpl();
            DataSource createdDataSource = dataSourcesDao.addDataSource(dataSource);
            return new Gson().toJson(createdDataSource);
        });
*/

        //------------- D E P E N D E N C I E S ----------------------------

        // SELECT all DEPENDENCIES records for a Data Source
        get("/dependencies/:id", (request, response) -> {
            Long dataSourceId = Long.valueOf(request.params("id").toString());
            DependenciesDao dependenciesDao = new DependenciesDaoImpl();
            List<Dependencies> dependencies = dependenciesDao.getAllDependenciesForDataSource(dataSourceId);
            return new Gson().toJson(dependencies);
        });

        //---------------  E W   C O N T R O L L E R S  ----------------------------

        get("/ewcontrollers", (request, response) -> {
            EwControllersDao ewControllersDao = new EwControllersDaoImpl();
            List<EwControllers> ewControllers = ewControllersDao.getAllEwControllers();
            return new Gson().toJson(ewControllers);
        });

        // SELECT 1
        get("/ewcontrollers/:id", (request, response) -> {
            Long ewcontrollersId = Long.valueOf(request.params(":id"));
            EwControllersDao ewcontrollersDao = new EwControllersDaoImpl();
            EwControllers ewcontrollers = ewcontrollersDao.getEwControllerById(ewcontrollersId);
            return new Gson().toJson(ewcontrollers);
        });

        //---------------  U P D A T E   I N T E R V A L S  ----------------------------

        // SELECT all
        get("/updateintervals", (request, response) -> {
            UpdateIntervalsDao updateIntervalsDao = new UpdateIntervalsDaoImpl();
            List<UpdateIntervals> updateIntervals = updateIntervalsDao.getAllUpdateIntervals();
            return new Gson().toJson(updateIntervals);
        });

        // SELECT 1
        get("/updateintervals/:id", (request, response) -> {
            Long updateintervalsId = Long.valueOf(request.params(":id"));
            UpdateIntervalsDao updateIntervalsDao = new UpdateIntervalsDaoImpl();
            UpdateIntervals updateintervals = updateIntervalsDao.getUpdateIntervalById(updateintervalsId);
            return new Gson().toJson(updateintervals);
        });

        //---------------  S O U R C E   T Y P E S  ----------------------------

        // SELECT all
        get("/sourcetypes", (request, response) -> {
            SourceTypesDao sourceTypesDao = new SourceTypesDaoImpl();
            List<SourceTypes> sourceTypes = sourceTypesDao.getAllSourceTypes();
            return new Gson().toJson(sourceTypes);
        });

        // SELECT 1
        get("/sourcetypes/:id", (request, response) -> {
            Long sourcetypesId = Long.valueOf(request.params(":id"));
            SourceTypesDao sourceTypesDao = new SourceTypesDaoImpl();
            SourceTypes sourceTypes = sourceTypesDao.getSourceTypeById(sourcetypesId);
            return new Gson().toJson(sourceTypes);
        });

        //---------------  U P D A T E   M E T H O D S  ----------------------------

        // SELECT all
        get("/updatemethods", (request, response) -> {
            UpdateMethodsDao updateMethodsDao = new UpdateMethodsDaoImpl();
            List<UpdateMethods> updateMethods = updateMethodsDao.getAllUpdateMethods();
            return new Gson().toJson(updateMethods);
        });

        // SELECT 1
        get("/updatemethods/:id", (request, response) -> {
            Long updateMethodsId = Long.valueOf(request.params(":id"));
            UpdateMethodsDao updateMethodsDao = new UpdateMethodsDaoImpl();
            UpdateMethods updateMethods = updateMethodsDao.getUpdateMethodById(updateMethodsId);
            return new Gson().toJson(updateMethods);
        });
    }
}
