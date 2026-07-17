import { Typography, Box } from "@mui/material";

import MealCardPlanningList from "../component/MealCardPlanningList";
import MealCardSummaryList from "../component/MealCardSummaryList";
import QuickLinks from "../component/QuickLinks";

const Dashboard = () => {
  return (
    <Box
      sx={{
        minHeight: "100dvh",
        width: "100%",
        bgcolor: "background.default",
        display: "flex",
        flexDirection: "column",
        gap: 5,
        px: {
          xs: 2,
          sm: 3,
          md: 5,
        },
        py: 1,
      }}
    >
      <Typography
        component="h1"
        variant="h4"
        sx={{
          fontWeight: 600,
        }}
      >
        Accueil
      </Typography>

      <Box
        sx={{
          display: "flex",
          flexDirection: {
            xs: "column",
            md: "row",
          },
          gap: 3,
        }}
      >
        <Box
          sx={{
            flex: "2 1 0",
          }}
        >
          <MealCardPlanningList />
        </Box>

        <Box
          sx={{
            flex: "1 1 0",
          }}
        >
          <MealCardSummaryList />
        </Box>
      </Box>

      <QuickLinks />
    </Box>
  );
};

export default Dashboard;
